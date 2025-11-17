import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1;j <= N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1;k <= N;k++) {
            for (int i = 1;i <= N;i++) {
                for (int j = 1;j <= N;j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1;i <= N;i++) {
            for (int j = 1;j <= N;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}