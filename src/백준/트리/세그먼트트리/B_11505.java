package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11505 {
    static long[] tree;
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수의 개수
        int M = Integer.parseInt(st.nextToken());   // 수의 변경이 일어나는 횟수
        int K = Integer.parseInt(st.nextToken());   // 구간의 곱을 구하는 횟수

        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize =(int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize + 1];
        Arrays.fill(tree, 1);

        int leafStartIndex = treeSize / 2 - 1;
        for (int i = leafStartIndex + 1; i <= leafStartIndex + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(tree.length - 1);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if (a == 1) {
                changeVal(leafStartIndex + s, e);
            } else {
                System.out.println((int) getMulti(leafStartIndex + s, leafStartIndex + (int) e));
            }
        }
    }

    public static long getMulti(int s, int e) {
        long result = 1;

        while (s <= e) {
            if (s % 2 == 1) {
                result = result * tree[s] % mod;
                s++;
            }

            if (e % 2 == 0) {
                result = result * tree[e] % mod;
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return result;
    }

    public static void changeVal(int index, long val) {
        tree[index] = val;

        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] % mod * tree[index * 2 + 1] % mod;
        }
    }

    public static void setTree(int idx) {
        while (idx > 1) {
            tree[idx / 2] = tree[idx / 2] * tree[idx] % mod;
            idx--;
        }
    }
}
