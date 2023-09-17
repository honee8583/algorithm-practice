package 백준.트리.트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B_14725 {
    public static class Node {
        private Map<String, Node> map = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 트라이 구성
        Node root = new Node();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());

            Node cur = root;
            for (int j = 0; j < K; j++) {
                String word = st.nextToken();

                if (!cur.map.containsKey(word)) {
                    cur.map.put(word, new Node());
                }

                cur = cur.map.get(word);
            }
        }

        printMap(root, "");
    }

    public static void printMap(Node node, String bar) {
        Object[] keySet = node.map.keySet().toArray();
        Arrays.sort(keySet);

        for (Object o : keySet) {
            System.out.println(bar + o);
            printMap(node.map.get(o), bar + "--");
        }
    }
}
