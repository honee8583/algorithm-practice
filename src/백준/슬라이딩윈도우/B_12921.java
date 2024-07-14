package 백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_12921 {
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

        long max = sum;
        // 이미 첫 슬라이딩 윈도우를 탐색한 이후이므로 1로 초기화
        // 만약 모든 배열의 숫자가 같은 숫자일경우 1로 초기화를 안한상태일경우 1이 부족한상태가 됨.
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
            bw.write("SAD\n");
        } else {
            bw.write(max + "\n");
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
