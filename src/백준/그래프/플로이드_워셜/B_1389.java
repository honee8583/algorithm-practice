package 백준.그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 유저의 수
        int M = Integer.parseInt(st.nextToken());   // 친구관계의 수

        // 인접행렬 초기화
        long[][] adj = new long[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 양방향그래프이므로 양쪽으로 연결
            adj[A][B] = 1;
            adj[B][A] = 1;
        }

        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    if (adj[S][K] != 10000001 && adj[K][E] != 10000001) {
                        adj[S][E] = Math.min(adj[S][E], adj[S][K] + adj[K][E]);
                    }
                }
            }
        }

        int answer = 0;
        long min = Integer.MAX_VALUE;
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] != 10000001) {
                    sum += adj[i][j];
                }
            }

            if (sum < min) {
                min = sum;
                answer = i;
            }
            sum = 0;
        }

        System.out.println(answer);
    }
}
