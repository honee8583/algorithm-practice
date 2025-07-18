import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i=0;i<=N;i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        DFS(1);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int node) {
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                cnt++;
                DFS(next);
            }
        }
    }
}