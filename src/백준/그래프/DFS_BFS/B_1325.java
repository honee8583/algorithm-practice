package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1325 {
    static int N;
    static int M;

    static ArrayList<Integer>[] list;    // 인접리스트
    static boolean[] visited;               // 방문 및 신뢰관계 배열
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   // 컴퓨터의 개수
        M = Integer.parseInt(st.nextToken());   // 신뢰관계의 개수

        count = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }

        List<Integer> resultList = new ArrayList<>();
        int max = Arrays.stream(count).max().getAsInt();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == max) {
                resultList.add(i);
            }
        }

        Collections.sort(resultList);
        for (int i : resultList) {
            System.out.print(i + " ");
        }
    }

    public static void BFS(int computer) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(computer);
        visited[computer] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i : list[cur]) {
                if (!visited[i]) {
                    visited[i] = true;
                    count[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
