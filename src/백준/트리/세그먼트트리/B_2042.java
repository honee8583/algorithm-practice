package 백준.트리.세그먼트트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2042 {
    static int N, M, K;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 구성
        int treeHeight = 0;
        int length = N;
        while (length != 0) {
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int leftNodeStartIndex = treeSize / 2 - 1;  // 리포노드의 시작 노드
        tree = new long[treeSize + 1];
        for (int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + N; i++) {
            tree[i] = Long.parseLong(bf.readLine());
        }

        setTree(treeSize - 1);  // 트리의 끝에서부터 구성시작

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // b번째수를 c로 바꾼다.
            if (a == 1) {
                change(leftNodeStartIndex + b, c);
            }
            // 구간합 구하기
            else if (a == 2) {
                b = b + leftNodeStartIndex;
                c = c + leftNodeStartIndex;
                System.out.println(getSum(b, (int) c));
            } else {
                return;
            }
        }
        bf.close();
    }

    public static void change(int index, long val) {
        // a 번째 값을 b로 바꾼다
        long diff = val - tree[index];

        while (index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    // 1. 질의 인덱스를 리프노드 인덱스로 바꾼다.
    // 2. start_index % 2 == 1 일경우 선택한다, end_index % 2 == 0 일경우 선택한다.
    // 3. 부모노드로 이동한다.선택됬을 경우 (start_index + 1) / 2, (end_index - 1) / 2
    // 4. 선택된 노드들의 값의 합을 구한다.
    public static long getSum(int a, int b) {
        long partSum = 0;

        while (a <= b) {
            if (a % 2 == 1) {
                partSum += tree[a];
                a++;
            }

            if (b % 2 == 0) {
                partSum += tree[b];
                b--;
            }

            a /= 2;
            b /= 2;
        }
        return partSum;
    }

    // 트리 구성 (부모노드 채우기)
    public static void setTree(int i) {
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }
}
