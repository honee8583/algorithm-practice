package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};
    public static void solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int count = BFS(maps, visited,0, 0);

        System.out.println(count);
    }

    public static int BFS(int[][] maps, boolean[][] visited, int i, int j) {
        int goalX = maps.length - 1;
        int goalY = maps[0].length - 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int k = 0; k < 4; k++) {
                // 다음좌표
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && y >= 0 && x < maps.length && y < maps[0].length) {
                    if (maps[x][y] == 1) {
                        queue.add(new int[]{x, y});
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                    }
                }
            }
        }

        if (!visited[goalX][goalY]) {
            return -1;
        }

        return maps[goalX][goalY];
    }
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        solution(maps); // 1

        maps = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        solution(maps); // -1
    }
}
