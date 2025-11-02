import java.io.*;
import java.util.*;

class Main {
    static int N, S, cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        DFS(0, 0);

        if (S == 0) {
            cnt--;
        }

        System.out.println(cnt);
    }

    public static void DFS(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }

        DFS(depth + 1, sum + arr[depth]);
        DFS(depth + 1, sum);
    }
}