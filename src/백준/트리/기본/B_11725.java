package 백준.트리.기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_11725 {
    static ArrayList<Integer>[] adj;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        parent = new int[N + 1];
        BFS();
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int node : adj[cur]) {
                if (parent[node] == 0) {
                    parent[node] = cur;
                    q.add(node);
                }
            }
        }
    }
}
