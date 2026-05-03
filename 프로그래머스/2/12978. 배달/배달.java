import java.util.*;
import java.io.*;

class Node {
    int node;
    int distance;
    
    Node (int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    
    List<Node>[] adj;
    boolean[] visited;
    int[] dist;
    int[] before;
    int min;
    
    public int solution(int N, int[][] roads, int K) {
        int answer = 0;

        // 양방향 그래프 인접리스트 구성
        adj = new ArrayList[N + 1];
        for (int i = 0;i <= N;i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];
            int distance = road[2];
            adj[s].add(new Node(e, distance));
            adj[e].add(new Node(s, distance));
        }
        
        min = K;
        visited = new boolean[N + 1];
        before = new int[N + 1];
        dist = new int[N + 1];
        for (int i = 2;i <= N;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dijkstra();
        
        // System.out.println(Arrays.toString(dist));
        
        for (int i = 1;i <= N;i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                answer++;
            }
        }

        return answer;
    }
    
    public void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        pq.add(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            // System.out.println(cur.node);
            
            visited[cur.node] = true;
            
            for (Node next : adj[cur.node]) {
                if (dist[cur.node] + next.distance < dist[next.node] && dist[cur.node] + next.distance <= min) {
                    dist[next.node] = dist[cur.node] + next.distance;  // 업데이트
                    before[next.node] = cur.node;
                    
                    if (!visited[next.node]) {
                        pq.add(new Node(next.node, dist[next.node]));
                    }
                }
            }
        }
    }
}