package 백준.트리.이진트리;

import java.io.IOException;
import java.util.Scanner;

public class B_1991 {
    static int N;
    static int[][] binaryTree;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        binaryTree = new int[26][2];
        for (int i = 0; i < N; i++) {
            String[] temp = sc.nextLine().split(" ");

            int node = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if (left == '.') {
                binaryTree[node][0] = -1;
            } else {
                binaryTree[node][0] = left - 'A';
            }

            if (right == '.') {
                binaryTree[node][1] = -1;
            } else {
                binaryTree[node][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    // 전위순회
    public static void preOrder(int node) {
        System.out.print((char) (node + 'A'));
        if (binaryTree[node][0] != -1) {
            preOrder(binaryTree[node][0]);
        }
        if (binaryTree[node][1] != -1) {
            preOrder(binaryTree[node][1]);
        }
    }

    // 중위순회
    public static void inOrder(int node) {
        if (binaryTree[node][0] != -1) {
            inOrder(binaryTree[node][0]);
        }
        System.out.print((char) (node + 'A'));
        if (binaryTree[node][1] != -1) {
            inOrder(binaryTree[node][1]);
        }
    }

    // 후위순회
    public static void postOrder(int node) {
        if (binaryTree[node][0] != -1) {
            postOrder(binaryTree[node][0]);
        }
        if (binaryTree[node][1] != -1) {
            postOrder(binaryTree[node][1]);
        }
        System.out.print((char) (node + 'A'));
    }
}
