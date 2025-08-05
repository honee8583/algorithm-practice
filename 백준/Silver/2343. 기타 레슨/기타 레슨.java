import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int s = 0;
        int e = 0;
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            s = Math.max(s, num);
            e += num;
        }
        
        
        int min = Integer.MAX_VALUE;
        while (s <= e) {
            int m = (s + e) / 2;

            // System.out.println(m);

            int cnt = 1;
            int sum = arr[1];
            for (int i = 2; i <= N; i++) {
                int num = arr[i];

                if (sum + num <= m) {
                    sum += num;
                } else {
                    // System.out.println("sum: " + sum + ", cnt: " + cnt);
                    sum = num;
                    cnt++;
                }
            }
            // System.out.println("sum: " + sum + ", cnt: " + cnt);

            if (cnt <= K) {
                min = Math.min(min, m);
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}