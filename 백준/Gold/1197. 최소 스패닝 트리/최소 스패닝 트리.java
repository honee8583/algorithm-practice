import java.io.*;
import java.util.*;

class Main {
    public static class Edge {
        int s;
        int e;
        int w;
        
        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int V, E;
    static int[][] dist;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        for (int i = 0;i < E;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, w));
        }

        parent = new int[V + 1];
        for (int i = 1;i <= V;i++) {
            parent[i] = i;
        }

        int useEdge = 0;
        int sum = 0;
        while (useEdge != V - 1) {
            Edge edge = pq.poll();

            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                sum += edge.w;
                useEdge++;
            }
        }

        // 모든 가중치의 합을 구하는 방법
        System.out.println(sum);
    }

    private static void union(int start, int end) {
        start = find(start); // 대표노드
        end  = find(end);    // 대표노드

        if (start != end) {
            parent[start] = end;
        }
    }

    private static int find(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}