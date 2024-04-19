package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_2252_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접리스트 구성
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 진입차수 배열 구성
        int[] D = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            D[B] += 1;          // 진입차수 증가
            adj.get(A).add(B);  // 인접리스트 추가
            adj.get(B).add(A);  // 인접리스트 추가
        }

        // 방문배열 구성
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {    // 진입차수 값이 0일 경우
                pq.add(i);
                visited[i] = true;
            }
        }

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            System.out.print(cur + " ");

            // 방문후 진입차수 감소
            for (int next : adj.get(cur)) {
                D[next]--;
            }

            for (int i = 1; i <= N; i++) {
                if (D[i] == 0 && !visited[i]) { // 진입차수가 0이고 방문한적이 없을 경우 추가
                    pq.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
