package 백준.그래프.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1219 {
    public static class Edge {
        int node;
        int next;
        int cost;

        public Edge(int node, int next, int cost) {
            this.node = node;
            this.next = next;
            this.cost = cost;
        }
    }

    static int N, S, E, M;
    static Edge[] edges;
    static long[] costs;
    static long[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 에지리스트 구성
        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(node, next, cost);
        }

        costs = new long[N];
        Arrays.fill(costs, Long.MIN_VALUE);

        st = new StringTokenizer(bf.readLine());
        money = new long[N];
        for (int i = 0; i < N; i++) {
            money[i] = Long.parseLong(st.nextToken());
        }

        costs[S] = money[S];
        for (int i = 0; i <= N + 100; i++) {   // 충분히 많이 반복
            for (int j = 0; j < M; j++) {   // 업데이트 수행
                Edge edge = edges[j];
                int node = edge.node;
                int next = edge.next;
                int cost = edge.cost;

                // 출발노드를 아직 방문하지 않았을 경우 스킵
                if (costs[node] == Long.MIN_VALUE) {
                    continue;
                // 출발노드가 양수 사이클에 연결된 노드일경우 도착노드도 연결노드로 업데이트(MAX)
                } else if (costs[node] == Long.MAX_VALUE) {
                    costs[next] = Long.MAX_VALUE;
                } else if (costs[next] < costs[node] + money[next] - cost) {
                    costs[next] = costs[node] + money[next] - cost;

                    // N - 1 반복 이후 업데이트되는 종료노드는 양수 사이클 연결노드로 변경
                    if (i >= N - 1) {
                        costs[next] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if (costs[E] == Long.MIN_VALUE) {
            System.out.println("gg");
        } else if (costs[E] == Long.MAX_VALUE) {
            System.out.println("Gee");
        } else {
            System.out.println(costs[E]);
        }
    }
}
