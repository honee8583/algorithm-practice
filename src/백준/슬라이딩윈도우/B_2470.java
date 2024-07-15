package 백준.슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int i = 0;
        int j = N - 1;
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[i];
                answer[1] = arr[j];
            }

            if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }

        bw.write(answer[0] + " " + answer[1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
