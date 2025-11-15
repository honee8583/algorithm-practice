import java.io.*;
import java.util.*;

class Main {
    static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int N, M, S, E;
    static List<Edge> edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] dist = new long[N];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[S] = 0;

        edgeList = new ArrayList<>();
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(s, e, w));
        }

        st = new StringTokenizer(br.readLine());
        int[] cost = new int[N];
        for (int i = 0;i < N;i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        dist[S] = cost[S];  // 시작도시에서도 돈을 범

        for (int i = 0;i < N + 100;i++) {
            for (Edge edge : edgeList) {
                int s = edge.s;
                int e = edge.e;
                int w = edge.w;

                if (dist[s] == Long.MIN_VALUE) {
                    continue;
                }

                // 시작도시가 양수사이클인 경우 도착도시도 양수 사이클에 포함
                if (dist[s] == Long.MAX_VALUE) {
                    dist[e] = Long.MAX_VALUE;
                }
                // 일반적인 업데이트
                else if (dist[e] < dist[s] - w + cost[e]) {
                    dist[e] = dist[s] - w + cost[e];

                    // N - 1번째부터는 양수사이클에 포함
                    if (i >= N - 1) {
                        dist[s] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (dist[E] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else if (dist[E] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else {
            System.out.println(dist[E]);
        }
    }
}