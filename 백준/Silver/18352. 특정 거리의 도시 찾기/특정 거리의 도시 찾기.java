import java.io.*;
import java.util.*;

class Main {
    static int N, M, K, X;
    static List<List<Integer>> adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 목표 최단거리
        X = Integer.parseInt(st.nextToken()); // 출발노드

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
        }

        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[X] = 0;

        BFS(X);

        boolean hasAnswer = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                hasAnswer = true;
                bw.write(i + "\n");
            }
        }

        if (!hasAnswer) {
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj.get(cur)) {
                if (dist[cur] + 1 < dist[next]) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}