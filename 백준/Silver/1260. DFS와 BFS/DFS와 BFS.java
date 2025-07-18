import java.io.*;
import java.time.Year;
import java.util.*;

class Main {
    static List<List<Integer>> adj;
    static List<Integer> dfs;
    static List<Integer> bfs;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adj.get(i));
        }

        dfs = new ArrayList<>();
        dfs.add(V);
        visited = new boolean[N + 1];
        visited[V] = true;
        DFS(V);

        bfs = new ArrayList<>();
        bfs.add(V);
        visited = new boolean[N + 1];
        visited[V] = true;
        BFS(V);

        for (int i : dfs) {
            bw.write(i + " ");
        }
        bw.write("\n");

        for (int i : bfs) {
            bw.write(i + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int node) {
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs.add(next);
                DFS(next);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    bfs.add(next);
                    q.add(next);
                }
            }
        }
    }
}