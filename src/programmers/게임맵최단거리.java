package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N, M;
    private static int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;

        visited = new boolean[N][M];
        BFS(maps);
        return !visited[N - 1][M - 1] ? -1 : maps[N - 1][M - 1];
    }

    private static void BFS(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur[0] + dx[i];
                int nextY = cur[1] + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                        q.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        maps[nextX][nextY] = maps[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }
}
