import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int leafNode;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int k = 1;
        while (Math.pow(2, k) < N) {
            k++;
        }
        
        leafNode = (int) Math.pow(2, k);

        tree = new long[leafNode * 2];
        Arrays.fill(tree, Long.MAX_VALUE);

        // 리프 노드 구성
        for (int i = 0;i < N;i++) {
            tree[leafNode + i] = Long.parseLong(br.readLine());
        }

        // 나머지 노드 구성
        for (int i = leafNode - 1;i >= 1;i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            printMin(a, b);
        }
    }

    private static void printMin(int start, int end) {
        long min = Long.MAX_VALUE;
        start = start + leafNode - 1;
        end = end + leafNode - 1;
        while (start <= end) {
            if (start % 2 == 1) {
                min = Math.min(min, tree[start]);
                start = (start + 1) / 2;
            } else {
                start /= 2;
            }

            if (end % 2 == 0) {
                min = Math.min(min, tree[end]);
                end = (end - 1) / 2;
            } else {
                end /= 2;
            }
        }

        System.out.println(min);
    }
}