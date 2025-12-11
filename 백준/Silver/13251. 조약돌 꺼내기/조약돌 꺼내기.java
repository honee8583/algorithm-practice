import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());   // 색깔의 종류

        int N = 0;  // 전체 조약돌의 개수
        int[] D = new int[M];   // 각 색깔 조약돌의 개수 배열
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            D[i] = Integer.parseInt(st.nextToken());
            N += D[i];
        }

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());   // 선택하는 조약돌의 수

        double result = 0.0;
        double[] dp = new double[51];
        for (int i = 0; i < M; i++) {
            // 선택하는 조약돌의 개수가 특정 색의 조약돌의 개수보다 적을 경우에만 가능
            if (D[i] >= K) {
                dp[i] = 1.0;    // TODO
                for (int k = 0; k < K; k++) {
                    dp[i] *= (double) (D[i] - k) / (N -k);
                }
            }
            result += dp[i];
        }

        System.out.println(result);
    }
}
