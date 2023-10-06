package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int[] mArr = new int[M];
        for (int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int k = 0; k < mArr.length; k++) {
            int target = mArr[k];

            boolean flag = false;

            int i = 0;
            int j = A.length - 1;
            while (i <= j) {
                int mid = (i + j) / 2;

                if (target == A[mid]) {
                    flag = true;
                    break;
                } else if (target < A[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }

            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
