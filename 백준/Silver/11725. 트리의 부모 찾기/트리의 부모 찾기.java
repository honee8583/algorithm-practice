import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        adj = new ArrayList<>();
        for (int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0;i < N - 1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visited = new boolean[N + 1];
        parent[1] = 1;
        visited[1] = true;
        DFS(1);

        for (int i = 2;i <= N;i++) {
            System.out.println(parent[i]);
        }
    }

    private static void DFS(int node) {
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                parent[next] = node;
                DFS(next);
            }
        }
    }
}