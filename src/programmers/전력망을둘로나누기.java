package programmers;

import java.util.*;

public class 전력망을둘로나누기 {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        // 인접리스트 선언
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 양방향 인접리스트로 구성
        // 전선 배열을 돌면서 각 전선이 끊어진 상태를 가정하고 인접리스트를 새로 구성
        // 인접리스트 구성 후 DFS/BFS로 집단의 개수 세기
        for (int i = 0; i < wires.length; i++) {
            setAdj(i, wires);

            int[] wire = wires[i];
            visited = new boolean[n + 1];

            int a = BFS(wire[0]);
            int b = BFS(wire[1]);
            answer = Math.min(answer, Math.abs(a - b));

            clearAdj(n);
        }
        
        return answer;
    }

    public static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;

            for (int next : adj.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return cnt;
    }
    
    public static void clearAdj(int n) {
        for (int i = 0; i <= n; i++) {
            adj.get(i).clear();
        }
    }
    
    public static void setAdj(int exceptIdx, int[][] wires) {
        for (int i = 0; i < wires.length; i++) {
            if (i != exceptIdx) {
                int[] wire = wires[i];
                adj.get(wire[0]).add(wire[1]);
                adj.get(wire[1]).add(wire[0]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
        System.out.println(solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(solution(7, new int[][]{{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}}));
    }
}
