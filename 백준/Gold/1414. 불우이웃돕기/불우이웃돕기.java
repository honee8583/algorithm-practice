import java.io.*;
import java.util.*;

class Main {

    private static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int N;
    static int[] parent;
    static List<Edge> edgeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int total = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        for (int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            char[] cArr = st.nextToken().toCharArray();
            
            for (int j = 0;j < N;j++) {
                int temp = 0;
                if (cArr[j] >= 'a' && cArr[j] <= 'z') {
                    temp = cArr[j] - 'a' + 1;
                } else if (cArr[j] >= 'A' && cArr[j] <= 'Z') {
                    temp = cArr[j] - 'A' + 27;
                }

                if (temp != 0) {
                    total += temp;
                    pq.offer(new Edge(i, j, temp));
                }
            }
        }

        parent = new int[N + 1];
        for (int i = 1;i <= N;i++) {
            parent[i] = i;
        }

        int useEdge = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            int s = edge.s;
            int e = edge.e;
            int w = edge.w;

            if (find(s) != find(e)) {
                union(s, e);
                sum += w;
                useEdge++;
            }
        }

        if (useEdge == N - 1) {
            System.out.println(total - sum);
        } else {
            System.out.println("-1");
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[a] = b;
        }
    }

    private static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

}