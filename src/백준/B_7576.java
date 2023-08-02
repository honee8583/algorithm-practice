package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_7576 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;
    static int[][] matrix;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());   // 가로
        int N = Integer.parseInt(st.nextToken());   // 세로

        // 이차원 배열 구성
        visited = new boolean[N][M];
        matrix = new int[N][M];
        boolean isAlreadyDone = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                // 이차원 배열 구성
                matrix[i][j] = Integer.parseInt(st.nextToken());
                // 시작점 리스트 구성
                if (matrix[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
                // 0이 존재하지 않을 경우 이미 모든 토마토가 익은 경우
                if (matrix[i][j] == 0) {
                    isAlreadyDone = false;
                }
            }
        }

        if (isAlreadyDone) {
            System.out.println(0);
            return;
        }

        // BFS
        BFS();

        // 결과값 찾기
        int max = Integer.MIN_VALUE;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }

                if (matrix[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }

    public static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        for (int[] al : list) {
            queue.add(al);
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (matrix[cur[0]][cur[1]] == -1) {
                continue;
            }

            visited[cur[0]][cur[1]] = true;

            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length) {
                    if (matrix[x][y] == 0 && !visited[x][y]) {
                        matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
