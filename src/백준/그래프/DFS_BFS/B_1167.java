package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1167 {
    static int N;
    static List<List<Node>> linkedList;
    static int[] distance;
    static boolean[] visited;

    static class Node {
        int next;
        int weight;

        Node (int next, int weight) {
            this.next = next;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        linkedList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            linkedList.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());

            while (true) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());

                linkedList.get(v).add(new Node(next, weight));
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(2);

        int idx = getMaxIdx();
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(idx);

        Arrays.sort(distance);
        System.out.println(distance[N]);
//        System.out.println(Arrays.stream(distance).max().getAsInt());
    }

    public static void BFS(int curV) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curV);
        visited[curV] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            visited[v] = true;

            for (Node node : linkedList.get(v)) {
                if (!visited[node.next]) {
                    distance[node.next] = distance[v] + node.weight;
                    q.add(node.next);
                }
            }
        }
    }

    public static int getMaxIdx() {
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 1; i <= N; i++) {
            if (distance[i] > max) {
                max = distance[i];
                maxIdx = i;
            }
        }

        return maxIdx;
    }
}
