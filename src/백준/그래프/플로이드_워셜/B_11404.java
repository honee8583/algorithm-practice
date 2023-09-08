package 백준.그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11404 {
    static int N, M;
    static int[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        // 인접행렬 초기화
        costs = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) {
                    costs[i][j] = 0;
                } else {
                    costs[i][j] = 10000001;
                }
            }
        }

        // 인접행렬 값 저장
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 새로 입력하는 값이 더 작을경우 입력한다.
            if (costs[a][b] > c) {
                costs[a][b] = c;
            }
        }

        // 플로이드-워셜 알고리즘(k -> i -> j)
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (costs[i][j] > costs[i][k] + costs[k][j]) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (costs[i][j] == 10000001) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(costs[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
