package 백준.그래프.DFS_BFS;

import java.io.*;
import java.util.*;

public class B_14940 {
    static int N, M;
    static int[][] adj;
    static int[][] distance;
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int startX, startY;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        startX = 0;
        startY = 0;
        adj = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                adj[i][j] = num;
                if (num == 2) {
                    startX = i;
                    startY = j;
                }
                if (num == 0) {
                    visited[i][j] = true;
                }
            }
        }

        distance = new int[N][M];
        BFS();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j])
                    System.out.print(-1 + " ");
                else
                    System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                // 다음 좌표
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (!visited[x][y] && adj[x][y] == 1) {
                        visited[x][y] = true;
                        distance[x][y] = distance[cur[0]][cur[1]] + 1;
                        q.add(new int[] {x, y});
                    }
                }
            }
        }
    }
}
