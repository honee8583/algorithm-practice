package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1916 {
    public static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost > o.cost) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        // 인접리스트 구성
        ArrayList<Node>[] adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, c));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[] result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[start] = 0;

        // 다익스트라 수행
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curCity = cur.city;
            if (visited[curCity]) continue;
            visited[curCity] = true;

            for (Node next : adj[curCity]) {
                int nextCity = next.city;
                int cost = next.cost;

                if (result[nextCity] > result[curCity] + cost) {
                    result[nextCity] = result[curCity] + cost;
                    pq.add(new Node(nextCity, result[nextCity]));
                }
            }
        }

        System.out.println(result[end]);
    }
}
