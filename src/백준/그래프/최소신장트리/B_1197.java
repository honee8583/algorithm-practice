package 백준.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1197 {
    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(A, B, C));
        }

        parent = new int[V + 1];  // 유니온 파인드 배열
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int N = 0;
        int sum = 0;
        while (!pq.isEmpty() && N != V - 1) {
            Edge edge = pq.poll();
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                N++;
                sum += edge.weight;
            }
        }

        System.out.println(sum);
    }

    public static void union(int a, int b) {
        if (parent[a] != parent[b]) {
            a = find(a);
            b = find(b);
        }

        if (a < b) {
            parent[b] = a;
        } else if (b < a){
            parent[a] = b;
        }
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}
