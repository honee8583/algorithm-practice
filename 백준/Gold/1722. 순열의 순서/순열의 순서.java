import java.io.*;
import java.util.*;

class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        long[] factorials = new long[N + 1];
        factorials[0] = 1;
        for (int i = 1;i <= N;i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        
        // 지정한 순서의 순열 구하기
        boolean[] visited = new boolean[N + 1];
        if (Q == 1) {
            long K = Long.parseLong(st.nextToken());

            for (int i = 0;i < N;i++) {  // 구하고 있는 자릿 수
                for (int j = 1;j <= N;j++) {  // 순열에 놓을 숫자
                    if (visited[j]) continue;

                    if (K - factorials[N - 1 - i] > 0) {
                        K -= factorials[N - 1 - i];
                    } else {
                        visited[j] = true;
                        System.out.print(j + " ");
                        break;
                    }
                }
            }
        } else {
            long K = 1; // ?
            for (int i = 0;i < N;i++) {
                int cur = Integer.parseInt(st.nextToken());
                for (int j = 1;j < cur;j++) {
                    if (visited[j]) continue;
                    K += factorials[N - 1 - i];
                }
                visited[cur] = true;
            }

            System.out.println(K);
        }
    }
}