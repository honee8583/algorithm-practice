package 백준.그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11404_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());    // 도시의 개수
        int m = Integer.parseInt(bf.readLine());    // 버스의 개수

        // 인접행렬 초기화
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = 10000001;   // MAX_VALUE(21억~)로 설정하면 안됌 / long 타입으로 해도 안됌
                }
            }
        }

        // 인접행렬 구성
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a][b] = Math.min(adj[a][b], c);
        }

        for (int k = 1; k <= n; k++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    adj[s][e] = Math.min(adj[s][e], adj[s][k] + adj[k][e]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] == 10000001) {
                    System.out.print("0 ");
                } else {
                    System.out.print(adj[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
