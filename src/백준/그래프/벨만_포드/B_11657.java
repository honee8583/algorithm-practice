package 백준.그래프.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11657 {
    public static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(A, B, C);
        }

        // 최단거리 배열
        long[] time = new long[N + 1];
        for (int i = 0; i <= N; i++) {
            time[i] = Integer.MAX_VALUE;
        }
        time[1] = 0;

        // N-1만큼 업데이트 반복
        for (int i = 1; i < N; i++) {
            // 모든 에지를 탐색하며 업데이트
            for (int j = 0; j < M; j++) {
                Edge cur = edges[j];
                int start = cur.start;
                int end = cur.end;
                int weight = cur.weight;

                if (time[start] != Integer.MAX_VALUE && time[end] > time[start] + weight) {
                    time[end] = time[start] + weight;
                }
            }
        }

        // 음수 사이클 확인 - 에지리스트를 반복하며 확인
        boolean flag = true;
        for (int i = 0; i < M; i++) {
            Edge cur = edges[i];
            int start = cur.start;
            int end = cur.end;
            int weight = cur.weight;

            if (time[start] != Integer.MAX_VALUE && time[end] > time[start] + weight) {
                flag = false;
                break;
            }
        }

        if (flag) {
            for (int i = 2; i <= N; i++) {
                if (time[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(time[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}