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

        N = Integer.parseInt(st.nextToken());  // 도시의 개수
        M = Integer.parseInt(st.nextToken());  // 도로의 개수
        K = Integer.parseInt(st.nextToken());  // 거리 정보
        X = Integer.parseInt(st.nextToken());  // 출발지

        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);  // 단방향 그래프
        }

        dist = new int[N + 1];  // 최소 거리 배열
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[X] = 0;
        BFS(X);

        boolean flag = false;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                flag = true;
                bw.write(i + "\n");
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else {
            bw.flush();
        }

        bw.close();
        br.close();
    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next : adj.get(cur)) {
                int distance = dist[cur] + 1;
                if (distance < dist[next]) {
                    dist[next] = distance;
                    q.add(next);
                }
            }
        }
    }
}