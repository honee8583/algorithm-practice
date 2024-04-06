package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1260 {
    static List<List<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 시작번호

        // 인접리스트 초기화
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 값 대입
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 방문할 수 있는 정점이 여러개인 경우 작은것 먼저 방문
        for (int i = 0; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        // 방문배열 초기화
        visited = new boolean[N + 1];
        DFS(V);

        System.out.println();

        visited = new boolean[N + 1];
        BFS(V);
    }

    public static void DFS(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");

        for (int next : adj.get(cur)) {
            if (!visited[next]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
