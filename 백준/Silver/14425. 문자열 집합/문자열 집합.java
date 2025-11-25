import java.io.*;
import java.util.*;

class Main {

    private static class Node {
        Node[] nodes;
        boolean isLeaf;

        public Node() {
            this.nodes = new Node[26];
            this.isLeaf = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        // 트라이 자료구조 구성
        Node trie = new Node();
        for (int i = 0;i < N;i++) {
            String str = sc.nextLine();
            Node cur = trie;
            for (int j = 0;j < str.length();j++) {
                char c = str.charAt(j);

                if (cur.nodes[c - 'a'] == null) {
                    cur.nodes[c - 'a'] = new Node();
                }

                if (j == str.length() - 1) {
                    cur.nodes[c - 'a'].isLeaf = true;
                }

                cur = cur.nodes[c - 'a'];
            }
        }

        int cnt = 0;
        for (int i = 0;i < M;i++) {
            Node cur = trie;

            String str = sc.nextLine();
            char[] cArr = str.toCharArray();
            for (int j = 0;j < cArr.length;j++) {
                int idx = cArr[j] - 'a';
                cur = cur.nodes[idx]; 

                if (cur == null) {
                    break;
                }

                if (j == cArr.length - 1 && cur.isLeaf) {  // 마지막 문자 & 리프노드
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}