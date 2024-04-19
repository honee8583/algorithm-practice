package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1753 {
    private static final String NOT_EXIST = "INF";

    public static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());

        // 인접리스트 구성
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{v, w});
        }


        // 최단거리 배열 초기화 (출발노드만 0, 나머지는 MAX)
        int[] distance = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            if (i == K) {
                distance[K] = 0;
            } else {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // 방문배열 초기화
        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) continue;
            visited[cur.to] = true;

            for (int[] next : adj.get(cur.to)) {
                int nextNode = next[0];
                int nextWeight = next[1];

                // 최단거리 업데이트
                if (distance[nextNode] > distance[cur.to] + nextWeight) {
                    distance[nextNode] = distance[cur.to] + nextWeight;
                    pq.add(new Node(nextNode, distance[nextNode]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (visited[i]) {   // 시작노드일 경우 0
                System.out.println(distance[i]);
            } else {
                System.out.println(NOT_EXIST);
            }
        }
    }
}
