package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2357 {
    static long[] minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leafStartNode = treeSize / 2 - 1;
        minTree = new long[treeSize + 1];
        maxTree = new long[treeSize + 1];
        Arrays.fill(minTree, Integer.MAX_VALUE);
        Arrays.fill(maxTree, Integer.MIN_VALUE);

        for (int i = leafStartNode + 1; i <= leafStartNode + N; i++) {
            long num = Long.parseLong(br.readLine());
            minTree[i] = num;
            maxTree[i] = num;
        }

        setTree(treeSize - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            s = s + leafStartNode;
            e = e + leafStartNode;
            System.out.println((int) getMin(s, e) + " " + (int) getMax(s, e));
        }
    }

    public static long getMin(int s, int e) {
        long min = Integer.MAX_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                min = Math.min(min, minTree[s]);
                s++;
            }

            if (e % 2 == 0) {
                min = Math.min(min, minTree[e]);
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return min;
    }

    public static long getMax(int s, int e) {
        long max = Integer.MIN_VALUE;
        while (s <= e) {
            if (s % 2 == 1) {
                max = Math.max(max, maxTree[s]);
                s++;
            }

            if (e % 2 == 0) {
                max = Math.max(max, maxTree[e]);
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return max;
    }

    public static void setTree(int idx) {
        while (idx > 1) {
            if (minTree[idx / 2] > minTree[idx]) {
                minTree[idx / 2] = minTree[idx];
            }
            if (maxTree[idx / 2] < maxTree[idx]) {
                maxTree[idx / 2] = maxTree[idx];
            }
            idx--;
        }
    }
}
