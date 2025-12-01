import java.io.*;
import java.util.*;

class Main {
    static int N, M, K;
    static int leafNode, treeSize;
    static final long DIV = 1000000007;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int k = 1;
        while (Math.pow(2, k) < N) {
            k++;
        }

        leafNode = (int) Math.pow(2, k);
        treeSize = leafNode * 2;
        tree = new long[treeSize];
        Arrays.fill(tree, 1);

        for (int i = 0;i < N;i++) {
            tree[leafNode + i] = Long.parseLong(br.readLine());
        }

        for (int i = leafNode - 1;i > 0;i--) {
            tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % DIV;
        }

        for (int i = 0;i < M + K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                // 데이터 업데이트
                update(b, c);
                // System.out.println(Arrays.toString(tree));
            } else {
                // 구간곱
                printMul(b, (int) c);
            }
        }
    }

    private static void update(int index, long num) {
        int idx = index + leafNode - 1;
        tree[idx] = num;
        idx /= 2;
        while (idx > 0) {
            tree[idx] = (tree[idx * 2] * tree[idx * 2 + 1]) % DIV;
            idx /= 2;
        }
    }

    private static void printMul(int start, int end) {
        long result = 1;
        start = start + leafNode - 1;
        end = end + leafNode - 1;
        while (start <= end) {
            if (start % 2 == 1) {
                result = (result * tree[start]) % DIV;
                start = (start + 1) / 2;
            } else {
                start /= 2;
            }

            if (end % 2 == 0) {
                result = (result * tree[end]) % DIV;
                end = (end - 1) / 2;
            } else {
                end /= 2;
            }
        }

        System.out.println(result);
    }
}