package 백준.트리.트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5052 {
    public static class tNode {
        private tNode[] tNodes = new tNode[10];
        private boolean isLeafNode;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(bf.readLine());
            int tempN = N;
            String[] words = new String[N];
            int idx = 0;

            tNode root = new tNode();

            // 트라이 구성
            while (N > 0) {
                tNode cur = root;

                StringTokenizer st = new StringTokenizer(bf.readLine());
                String s = st.nextToken();
                words[idx++] = s;

                for (int j = 0; j < s.length(); j++) {
                    String sub = s.substring(j, j + 1);
                    int num = Integer.parseInt(sub);

                    if (cur.tNodes[num] == null) {
                        cur.tNodes[num] = new tNode();
                    }

                    cur = cur.tNodes[num];

                    if (j == s.length() - 1) {
                        cur.isLeafNode = true;
                    }
                }
                N--;
            }

            // 트라이 검사
            boolean flag = true;
            for (int j = 0; j < tempN; j++) {
                String word = words[j];
                tNode cur = root;

                for (int k = 0; k < word.length(); k++) {
                    int next = Integer.parseInt(word.substring(k, k + 1));

                    if (cur.tNodes[next] == null) {
                        cur.tNodes[next] = new tNode();
                    }

                    cur = cur.tNodes[next];

                    if (k != word.length() - 1 && cur.isLeafNode) {
                        flag = false;
                    }
                }
            }

            if (!flag) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
