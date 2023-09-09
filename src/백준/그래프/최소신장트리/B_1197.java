package 백준.그래프.최소신장트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1197 {
    static int V, E;
    static int[] parent;

    public static class Edge implements Comparable<Edge> {
        int node;
        int next;
        long weight;

        public Edge(int node, int next, long weight) {
            this.node = node;
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (this.weight > o.weight) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        } else {
            return parent[node] = find(parent[node]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        // 대표노드가 다를경우에만 병합
        if (a != b) {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수

        // 유니온 파인드 배열 초기화(인덱스값으로 초기화)
        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        // 에지리스트 생성(가중치 오름차순 정렬)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(a, b, c));
        }

        // 최소신장트리 구성
        int num = 0;
        int sum = 0;
        while (num < V - 1) {   // 정점의 개수 - 1 만큼만 반복한다.(pq가 빌때까지가 아니다)
            Edge cur = pq.poll();

            // 대표노드가 다를 경우에만 union연산 수행하면서 가중치 합 계산
            if (find(cur.node) != find(cur.next)) {
                union(cur.node, cur.next);
                sum += cur.weight;
                num++;
            }
        }

        System.out.println(sum);
    }
}
