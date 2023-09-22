package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10868 {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int length = N;
        int treeHeight = 0;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize + 1];
        Arrays.fill(tree, Integer.MAX_VALUE);
        int leafStartNode = treeSize / 2 - 1;
        for (int i = leafStartNode + 1; i <= leafStartNode + N; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        setTree(treeSize - 1);

        System.out.println(Arrays.toString(tree));

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(getMin(leafStartNode + a, leafStartNode + b));
        }

        br.close();
    }

    public static long getMin(int start_index, int end_index) {
        long min = Integer.MAX_VALUE;

        while (start_index <= end_index) {
            if (start_index % 2 == 1) {
                min = Math.min(min, tree[start_index]);
                start_index++;
            }

            if (end_index % 2 == 0) {
                min = Math.min(min, tree[end_index]);
                end_index--;
            }

            start_index /= 2;
            end_index /= 2;
        }

        return min;
    }

    public static void setTree(int idx) {
        while (idx != 1) {
            if (tree[idx / 2] > tree[idx]) {
                tree[idx / 2] = tree[idx];
            }
            idx--;
        }
    }
}
