import java.io.*;
import java.util.*;

class Main {
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<M;i++) {
            int target = Integer.parseInt(st.nextToken());

            boolean result = findTarget(target);
            if (result) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean findTarget(int target) {
        int start = 0;
        int end = A.length - 1;

        boolean result = false;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == A[mid]) {
                result = true;
                break;
            } else if (target < A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}