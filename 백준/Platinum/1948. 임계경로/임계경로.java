import java.io.*;
import java.util.*;

class Main {
    static int N, M, start, end, cnt;
    static int[] indegree;
    static long[] dist;
    static boolean[] visited;
    static List<List<Node>> adj, rAdj;

    private static class Node {
        int v;
        int w;

        public Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        rAdj = new ArrayList<>();
        for (int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
            rAdj.add(new ArrayList<>());
        }

        StringTokenizer st;
        indegree = new int[N + 1];
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Node(v, w));
            rAdj.get(v).add(new Node(u, w));
            indegree[v]++;
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new long[N + 1];
        getCriticalPath();

        cnt = 0;
        visited = new boolean[N + 1];
        visited[end] = true;
        reverseDfs(end);

        System.out.println(dist[end]);
        System.out.println(cnt);
    }

    private static void getCriticalPath() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1;i <= N;i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node next : adj.get(cur)) {
                dist[next.v] = Math.max(dist[next.v], dist[cur] + next.w);
                indegree[next.v]--;
                if (indegree[next.v] == 0) {
                    q.offer(next.v);
                }
            }
        }
    }

    private static void reverseDfs(int cur) {
        for (Node next : rAdj.get(cur)) {
            int v = next.v;
            if (dist[v] + next.w == dist[cur]) {
                cnt++;
                if (!visited[v]) {
                    visited[v] = true;
                    reverseDfs(v);
                }
            }
        }
    }
}