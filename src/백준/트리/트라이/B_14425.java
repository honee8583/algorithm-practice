package 백준.트리.트라이;

import java.util.Scanner;

public class B_14425 {
    public static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;  // 리프노드여부
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 트라이 구성
        tNode root = new tNode();   // 루트노드
        while (N > 0) {
            String text = sc.next();
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }

                now = now.next[c - 'a'];

                // 리포노드 설정
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            N--;
        }

        int count = 0;
        while (M > 0) {
            String text = sc.next();
            tNode now = root;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                // 다음 문자가 존재하지 않을 경우
                if (now.next[c - 'a'] == null) {
                    break;
                }

                now = now.next[c - 'a'];

                // 마지막 문자까지 도달하고 리프노드일경우 문자열이 존재
                if (i == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }

            M--;
        }
        System.out.println(count);
    }
}
