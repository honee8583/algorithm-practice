import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        final int INF = 100000000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1;i <= N;i++) {
            for (int j = 1;j <= N;j++) {
                arr[i][j] = INF;
            }
        }

        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A][B] = 1;
            arr[B][A] = 1;
        }

        for (int k = 1;k <= N;k++) {
            for (int i = 1;i <= N;i++) {
                for (int j = 1;j <= N;j++) {

                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1;i <= N;i++) {
            int[] sub = arr[i];

            int sum = 0;
            for (int j = 1;j <= N;j++) {
                if (i == j) continue;
                sum += sub[j];
            }

            min = Math.min(sum, min);
        }

        int idx = Integer.MAX_VALUE;
        for (int i = 1;i <= N;i++) {
            int[] sub = arr[i];

            int sum = 0;
            for (int j = 1;j <= N;j++) {
                if (i == j) continue;
                sum += sub[j];
            }

            if (sum == min) {
                idx = Math.min(idx, i);
            }
        }

        System.out.println(idx);
    }
}