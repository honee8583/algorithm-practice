import java.io.*;
import java.util.*;

class Main {
    static int V, E, K;
    static long[] dist;
    static boolean[] visited;
    static List<List<Node>> adj;
    private static class Node {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());  // 정점 수
        E = Integer.parseInt(st.nextToken());  // 간선 수
        K = Integer.parseInt(br.readLine());   // 시작 정점

        adj = new ArrayList<>();
        for (int i = 0;i <= V;i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0;i < E;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Node(v, w));
        }

        dist = new long[V + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.w - y.w);
        pq.offer(new Node(K, 0));

        visited = new boolean[V + 1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.v]) continue;
            visited[cur.v] = true;

            for (Node next : adj.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.offer(new Node(next.v, (int) dist[next.v]));
                }
            }
        }

        for (int i = 1;i <= V;i++) {
            if (!visited[i]) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

    }
}