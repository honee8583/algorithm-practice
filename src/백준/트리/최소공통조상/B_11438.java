package 백준.트리.최소공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11438 {
    static int k;
    static ArrayList<Integer>[] list;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 인접리스트 생성
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접리스트 구성
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // 2. k 구하기(N >= 2^k를 만족하는 k의 최댓값)
        int temp = 1;
        k = 0;
        while (temp <= N) {
            temp <<= 1;
            k++;
        }

        parent = new int[k + 1][N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1); // 3. 부모노드 및 깊이 저장

        // 4. 나머지 부모 노드 구하기(점화식 사용)
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }

        // 5. LCA 구하기
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int LCA = getLCA(a, b);
            System.out.println(LCA);
        }

        br.close();
    }

    public static int getLCA(int a, int b) {
        if (depth[a] > depth[b]) {  // b의 깊이가 더 깊음
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 깊이 맞추기
        for (int i = k; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[b] - depth[a]) {
                if (depth[a] <= depth[parent[i][b]]) {
                    b = parent[i][b];
                }
            }
        }

        // LCA 찾기
        for (int i = k; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        int LCA = a;
        if (a != b) {
            LCA = parent[0][LCA];
        }
        return LCA;
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    parent[0][next] = cur;
                    depth[next] = level;
                }
            }

            count++;
            if (count == now_size) {
                count = 0;
                now_size = q.size();
                level++;
            }
        }
    }
}
