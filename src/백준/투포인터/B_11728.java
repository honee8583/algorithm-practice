package 백준.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] A = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int[] B = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            bw.write(arr[i] + " ");
//        }

        int i = 0;
        int j = 0;
        int idx = 0;
        int[] answer = new int[a + b];
        while (i < a || j < b) {
            if (A[i] < B[j]) {
                answer[idx++] = A[i++];
            } else {
                answer[idx++] = B[j++];
            }

            if (i >= a) {
                while (j < b) {
                    answer[idx++] = B[j++];
                }
            } else if (j >= b) {
                while (i < a) {
                    answer[idx++] = A[i++];
                }
            }
        }

        for (int k = 0; k < answer.length; k++) {
            bw.write(answer[k] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
