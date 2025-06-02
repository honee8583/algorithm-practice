import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }

        long max = sum;
        int i = 0;
        int j = i + m - 1;
        while (j < n) {
            max = Math.max(max, sum);

            if (j + 1 < n) {
                sum -= arr[i];
                i++;
                j++;
                sum += arr[j];
            } else {
                break;
            }
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}