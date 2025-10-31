import java.io.*;
import java.util.*;


class Main {

    static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    static int N, M;
    static boolean[] visited;
    static List<List<Node>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parse(br.readLine());
        M = parse(br.readLine());

        adj = new ArrayList<>();
        for(int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = parse(st.nextToken());
            int v = parse(st.nextToken());
            int w = parse(st.nextToken());

            adj.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int K = parse(st.nextToken());
        int E = parse(st.nextToken());

        int[] dist = new int[N + 1];
        for (int i = 1;i <= N;i++) {
            if (i == K) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.next;

            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (Node nextNode : adj.get(cur)) {
                int next = nextNode.next;
                int cWeight = nextNode.weight;
                dist[next] = Math.min(dist[next], dist[cur] + cWeight);
                if (!visited[next]) {
                    pq.add(new Node(next, dist[next]));
                }
            }
        }

        System.out.println(dist[E]);
    }

    public static int parse(String token) {
        return Integer.parseInt(token);
    }
}