import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int i = 0;
        int j = N - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == M) {
                cnt++;
                j--;
            } else if (sum > M) {
                j--;
            } else if (sum < M) {
                i++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}