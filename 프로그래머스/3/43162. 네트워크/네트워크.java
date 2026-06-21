import java.util.*;
import java.io.*;

class Solution {
    List<List<Integer>> adj;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {        
        // 양방향 그래프 인접리스트 구성
        adj = new ArrayList<>();
        for (int i = 0;i < n;i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n;j++) {
                if (i != j && computers[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        // 방문배열 생성
        visited = new boolean[n];
        
        // DFS 수행
        int cnt = 0;
        for (int i = 0;i < n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);    
                System.out.println(Arrays.toString(visited));
                cnt++;
                System.out.println("i: " + i + ", cnt: " + cnt);
            }
        }
        
        return cnt;
    }
    
    private void DFS(int cur) {
        for (int next : adj.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                System.out.println(next);
                DFS(next);
            }
        }
    }
}