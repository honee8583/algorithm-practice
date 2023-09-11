package 백준.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1414 {
    static int[][] lines;
    static int[] parent;
    static PriorityQueue<Edge> edges;

    public static class Edge implements Comparable<Edge> {
        int l1;
        int l2;
        int len;

        public Edge (int l1, int l2, int len) {
            this.l1 = l1;
            this.l2 = l2;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return this.len - o.len;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int total = 0;
        lines = new int[N][N];
        edges = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);

                if (c >= 'a' && c <= 'z') {
                    lines[i][j] = c - 'a' + 1;
                } else if (c >= 'A' && c <= 'Z') {
                    lines[i][j] = c - 'A' + 27;
                }

                if (i != j && lines[i][j] != 0) {
                    edges.offer(new Edge(i + 1, j + 1, lines[i][j]));
                }
                total += lines[i][j];
            }
        }

        parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // 최소신장트리 알고리즘 수행
        int sum = 0;
        int usedEdge = 0;
        while (!edges.isEmpty()) {
            Edge cur = edges.poll();

            // 에지리스트를 순환하며 두 노드의 대표노드가 다를 경우 병합 수행
            if (find(cur.l1) != find(cur.l2)) {
                union(cur.l1, cur.l2);
                sum += cur.len;
                usedEdge++;
            }
        }

        // 기존 내 방식 : 모든 노드에 대해서 다시 find() 수행 -> 부모가 다른노드가 있을 경우 -1 출력
        // 답안 : 최소신장트리 알고리즘에서 사용한 에지 개수가 N - 1이 아닐경우 -1 출력(=모든 노드 연결 불가능)
        if (usedEdge == N - 1) {
            System.out.println(total - sum);
        } else {
            System.out.println(-1);
        }
    }

    public static int find(int line) {
        if (parent[line] == line) {
            return line;
        } else {
            return parent[line] = find(parent[line]);
        }
    }

    public static void union(int l1, int l2) {
        l1 = find(l1);
        l2 = find(l2);

        if (l1 != l2) {
            parent[l2] = l1;
        }
    }
}
