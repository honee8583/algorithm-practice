import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static int treeSize, leafIdx;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 수의 개수
        M = Integer.parseInt(st.nextToken());  // 수 변경 횟수
        K = Integer.parseInt(st.nextToken());  // 구간합 구하기 횟수

        int k = 1;
        while ((int) Math.pow(2, k) < N) {
            k += 1;
        }

        
        leafIdx = (int) Math.pow(2, k);
        treeSize = leafIdx * 2;
        tree = new long[treeSize];
        for (int i = 0;i < N;i++) {
            tree[leafIdx + i] = Long.parseLong(br.readLine());
        }

        for (int i = leafIdx - 1;i >= 1;i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        for (int i = 0;i < M + K;i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update((int) b, c);
            } else {
                System.out.println(arraySum((int) b, (int) c));
            }
        }
    }

    private static long arraySum(int start, int end) {
        long sum = 0;
        start = start + leafIdx - 1;
        end = end + leafIdx - 1;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start = (start + 1) / 2;
            } else {
                start /= 2;
            }

            if (end % 2 == 0) {
                sum += tree[end];
                end = (end - 1) / 2;
            } else {
                end /= 2;
            }
        }

        return sum;
    }

    private static void update(int idx, long num) {
        idx = idx + leafIdx - 1;
        long diff = num - tree[idx];
        while (idx > 0) {
            tree[idx] += diff;
            idx /= 2;
        }
    }
}