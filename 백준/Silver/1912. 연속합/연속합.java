import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = arr[0];

        for (int i = 1; i < N; i++) {
            int tmp = dp[i - 1] + arr[i];
            if (tmp > arr[i]) {
                dp[i] = tmp;
            } else {
                dp[i] = arr[i];
            }
        }

        bw.write(Arrays.stream(dp).max().getAsInt() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
