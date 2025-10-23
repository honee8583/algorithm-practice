import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] L = new int[N];
        int[] R = new int[N];
        L[0] = arr[0];
        R[N - 1] = arr[N - 1];

        int result = L[0];
        for (int i = 1; i < N; i++) {
            L[i] = Math.max(L[i - 1] + arr[i], arr[i]);
            R[N - i - 1] = Math.max(R[N - i] + arr[N - i - 1], arr[N - i - 1]);
            result = Math.max(result, L[i]);
        }

        for (int i = 1; i < N - 1; i++) {
            result = Math.max(L[i - 1] + R[i + 1], result);
        }

        System.out.println(result);
    }
}