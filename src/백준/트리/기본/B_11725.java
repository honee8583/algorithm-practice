package 백준.트리.기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_11725 {
    static ArrayList<Integer>[] adj;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 양방향 인접리스트
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adj[S].add(E);
            adj[E].add(S);
        }

        parent = new int[N + 1];
        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int cur) {
        for (int next : adj[cur]) {
            if (parent[next] == 0) {
                parent[next] = cur;
                DFS(next);
            }
        }
    }
}
