package 백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int max = 1;
        int[] cnt = new int[100001];
        while (j < N) {
            // 중복개수가 K개를 넘지 않는 곳까지 j를 옮긴다.
            while (j < N && cnt[arr[j]] + 1 <= K) {
                cnt[arr[j]]++;
                j++;
            }
            max = Math.max(max, j - i);
            cnt[arr[i++]]--;    // i를 옮기기 시작하고 옮길때마다 개수를 차감해준다.
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
