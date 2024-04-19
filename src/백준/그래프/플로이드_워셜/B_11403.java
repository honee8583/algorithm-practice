package 백준.그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 인접행렬 구성
        int[][] adj = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int K = 1; K <= N; K++) {
            for (int S = 1; S <= N; S++) {
                for (int E = 1; E <= N; E++) {
                    if (adj[S][K] == 1 && adj[K][E] == 1) {
                        adj[S][E] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
