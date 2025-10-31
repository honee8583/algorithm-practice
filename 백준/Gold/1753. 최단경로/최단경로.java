import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node> {
        public int next;
        public int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    static int V, E, K;
    static int[] dist;
    static boolean[] visited;
    static List<List<Node>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = parse(st.nextToken());
        E = parse(st.nextToken());
        K = parse(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0;i <= V;i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 구성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = parse(st.nextToken());
            int v = parse(st.nextToken());
            int w = parse(st.nextToken());

            adj.get(u).add(new Node(v, w));
        }

        // 최단배열 구성
        // 시작노드는 0으로 설정
        // 나머지는 무한대로 설정
        dist = new int[V + 1];
        dist[K] = 0;
        visited = new boolean[V + 1];
        for (int i = 1;i <= V; i++) {
            if (i != K) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int cur = node.next;
            if (visited[cur]) {  // K, 0
                continue;
            }
            visited[cur] = true; // K = true

            for (Node nextNode : adj.get(cur)) {  // (2, 2), (3, 3)
                int next = nextNode.next;  // 다음 노드 번호
                int weight = nextNode.weight;  // 다음 노드로의 가중치
                dist[next] = Math.min(dist[next], dist[cur] + weight);
                if (!visited[next]) {
                    q.add(new Node(next, dist[next]));
                }
            }
        }

        for (int i = 1;i <= V;i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    public static Integer parse(String token) {
        return Integer.parseInt(token);
    }
}