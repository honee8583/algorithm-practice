import java.io.*;
import java.util.*;

class Main {
    static final int DEPTH = 5;
    static int N, M;
    static boolean result;
    static List<List<Integer>> adj;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        result = false;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, 1);
            }
        }

        if (!result) {
            bw.write("0\n");
        } else {
            bw.write("1\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int node, int depth) {
        if (result) {
            return;
        }

        if (depth == DEPTH) {
            result = true;
            return;
        }

        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                DFS(next, depth + 1);
                visited[next] = false;
            }
        }
    }
}