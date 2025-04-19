package 백준.그래프.DFS_BFS;

import java.util.*;
import java.io.*;

// '임의의 노드'에서 가장 긴거리의 노드는 '트리의 지름'에 해당하는 두개의 노드중 하나이다.
// 즉 모든 노드에서 가장 긴거리의 노드를 탐색했을 때 도차가하는 노드는 트리의 지름에 해당하는 두개의 노드중 하나이다.
// 따라서 임의의 노드에서 가장 긴거리의 끝 노드를 구하고
// 끝 노드에서 다시 한번 탐색을 해 가장 긴거리의 끝 노드를 구하면 각각 두개의 노드가 트리의 지름을 구성한다.

// 인접행렬을 처음에 사용하려 했으나, 인접행렬을 사용하게 되면 정점이 많아질경우 메모리를 초과하게 된다.
// 따라서 인접리스트를 사용해서 메모리 초과를 방지할 수 있다.
public class B_1178_트리의지름 {
    static int N;
    static List<List<Edge>> adj;
    static int[] distance;
    static boolean[] visited;

    static class Edge {
        int next;
        int weight;

        public Edge(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 인접리스트 생성
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 구성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int b = Integer.parseInt(st.nextToken());
                if (b == -1) {
                    break;
                }

                int w = Integer.parseInt(st.nextToken());
                adj.get(num).add(new Edge(b, w));
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        visited[1] = true;
        DFS(1);
//        BFS(1);

        int next = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[i] > distance[next]) {
                next = i;
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        visited[next] = true;
        DFS(next);
//        BFS(next);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (distance[i] > max) {
                max = distance[i];
            }
        }

        bw.write(max + "\n");
        bw.close();
        br.close();
    }

    private static void DFS(int node) {
        for (Edge e : adj.get(node)) {
            if (!visited[e.next]) {
                distance[e.next] = distance[node] + e.weight;
                visited[e.next] = true;
                DFS(e.next);
            }
        }
    }

    private static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 인접리스트 순환
            for (Edge e : adj.get(cur)) {
                if (!visited[e.next]) {
                    distance[e.next] = distance[cur] + e.weight;
                    visited[e.next] = true;
                    q.add(e.next);
                }
            }
        }
    }
}
