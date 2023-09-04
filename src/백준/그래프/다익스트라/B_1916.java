package 백준.그래프.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1916 {
    public static int N, M;
    public static ArrayList<Node>[] list;
    public static boolean[] visited;
    public static int[] costs;

    public static class Node implements Comparable<Node> {
        int num;
        int cost;

        public Node (int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost > o.cost) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());   // 도시의 개수
        int M = Integer.parseInt(bf.readLine());   // 버스의 개수

        // 연결리스트 구성
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int busA = Integer.parseInt(st.nextToken());
            int busB = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[busA].add(new Node(busB, cost));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        costs = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            costs[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int n = cur.num;

            if (visited[n]) continue;
            visited[n] = true;

            for (Node node : list[n]) {
                int next = node.num;
                int cost = node.cost;

                if (costs[next] > costs[n] + cost) {
                    costs[next] = costs[n] + cost;
                    pq.offer(new Node(next, costs[next]));
                }
            }
        }

        System.out.println(costs[end]);
    }
}
