import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 100000001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] dist = new int[N + 1][N + 1];
        for (int i = 0;i <= N;i++) {
            for (int j = 0;j <= N;j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[s][e] = Math.min(dist[s][e], w);
        }

        for (int k = 1;k <= N;k++) {
            for (int i = 1;i <= N;i++) {
                for (int j = 1;j <= N;j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1;i <= N;i++) {
            for (int j = 1;j <= N;j++) {
                if (dist[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}