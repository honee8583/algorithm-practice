package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1753 {
    public static int V, E, K;
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<Node>[] list;

//    static class Node implements Comparable<Node> {
//        int vertex;
//        int weight;
//
//        public Node(int vertex, int weight) {
//            this.vertex = vertex;
//            this.weight = weight;
//        }
//
//        @Override
//        public int compareTo(Node o) {
//            if (this.weight > o.weight) {
//                return 1;
//            } else {
//                return -1;
//            }
//        }
//    }

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점 개수
        E = Integer.parseInt(st.nextToken());   // 간선 개수

        st = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());   // 시작 노드

        // 인접리스트 노드로 구성
        list = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
        }

        distance = new int[V + 1];
        visited = new boolean[V + 1];
        for (int i = 0; i <= V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
        q.offer(new Node(K, 0));
        distance[K] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int v = cur.vertex;

            if (visited[v]) {
                continue;
            }
            visited[v] = true;

            for (int i = 0; i < list[v].size(); i++) {
                Node node = list[v].get(i);
                int next = node.vertex;
                int weight = node.weight;

                if (distance[next] > distance[v] + weight) {
                    distance[next] = distance[v] + weight;
                    q.offer(new Node(next, distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }
}
