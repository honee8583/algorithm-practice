import java.io.*;
import java.util.*;

class Main {

    private static class tNode {
        tNode[] next = new tNode[26];
        boolean isLeaf = false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        tNode root = new tNode();
        for (int i = 0;i < N;i++) {
            String target = sc.nextLine();
            tNode cur = root;
            for (int j = 0;j < target.length();j++) {
                char c = target.charAt(j);

                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new tNode();
                }

                if (j == target.length() - 1) {
                    cur.next[c - 'a'].isLeaf = true;
                }

                cur = cur.next[c - 'a'];
            }
        }

        int cnt = 0;
        for (int i = 0;i < M;i++) {
            String target = sc.nextLine();
            tNode cur = root;
            for (int j = 0;j < target.length();j++) {
                char c = target.charAt(j);

                if (cur.next[c - 'a'] == null) {
                    break;
                }

                if (j == target.length() - 1 && cur.next[c - 'a'].isLeaf) {
                    cnt++;
                    break;
                }

                cur = cur.next[c - 'a'];
            }
        }

        System.out.println(cnt);
    }
}