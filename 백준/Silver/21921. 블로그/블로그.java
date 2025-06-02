import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int k = 0; k < X; k++) {
            sum += arr[k];
        }

        // sum = 5
        long max = sum;
        int cnt = 1;
        for (int i = 0; i < N - X; i++) {
            sum = sum - arr[i] + arr[i + X];

            if (sum > max) {
                cnt = 1;
                max = sum;
            } else if (sum == max){
                cnt++;
            }
        }

        if (max <= 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }

        bw.close();
        br.close();
    }
}
