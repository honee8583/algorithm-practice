import java.util.*;
import java.io.*;

class Location {
    int x;
    int y;
    
    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    
    static int N, M;
    
    static char[][] map;
    static int[][] dist;
    
    public int solution(String[] maps) {
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length();

        Location S = null;
        Location E = null;
        Location L = null;
        
        map = new char[N][M];
        for (int i = 0;i < N;i++) {
            char[] cArr = maps[i].toCharArray();
            for (int j = 0;j < M;j++) {
                map[i][j] = cArr[j];
                if (map[i][j] == 'S') {
                    S = new Location(i, j);
                } else if (map[i][j] == 'E') {
                    E = new Location(i, j);
                } else if (map[i][j] == 'L') {
                    L = new Location(i, j);
                }
            }
        }
        
        dist = new int[N][M];
        
        int toLever = BFS(S, L);
        int toEnd = BFS(L, E);
        
        if (toLever == -1 || toEnd == -1) return -1;
        
        return toLever + toEnd;
    }
    
    private static int BFS(Location start, Location end) {
        int[][] dist = new int[N][M];
        dist[start.x][start.y] = 1;
        
        Queue<Location> q = new LinkedList<>();
        q.add(start);
        
        while (!q.isEmpty()) {
            Location cur = q.poll();
            
            for (int i = 0;i < 4;i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
        
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (map[nextX][nextY] == 'X') continue;
                    
                    if (dist[nextX][nextY] > 0) continue;
                    
                    dist[nextX][nextY] = dist[cur.x][cur.y] + 1;
                    
                    q.add(new Location(nextX, nextY));
                    
                    if (nextX == end.x && nextY == end.y) {
                        return dist[nextX][nextY] - 1;
                    }
                }
            }
        }
        
        return -1;
    }
}