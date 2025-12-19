import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        for (int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N + 2];
        for (int i = N;i > 0;i--) {
            if (i + T[i] - 1 <= N) {
                // DP[i] = DP[i + T[i]] + P[i];
                DP[i] = Math.max(DP[i + 1], DP[i + T[i]] + P[i]);
            } else {
                DP[i] = DP[i + 1];
            }
        }

        // System.out.println(Arrays.toString(DP));

        System.out.println(DP[1]);
    }
}