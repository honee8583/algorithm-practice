package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2468 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static int N;
    static int[][] matrix;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][N];

        int max = Integer.MIN_VALUE;
        // 배열 구성
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, matrix[i][j]);
            }
        }

        int maxCnt = Integer.MIN_VALUE;
        for (int rain = 0; rain <= max; rain++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (matrix[j][k] > rain && !visited[j][k]) {
                        dfs(j, k, rain);
                        cnt++;
                    }
                }
            }
            maxCnt = Math.max(maxCnt, cnt);
        }

        System.out.println(maxCnt);
    }

    public static void dfs(int x, int y, int rain) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && matrix[nx][ny] > rain) {
                    dfs(nx, ny, rain);
                }
            }
        }
    }
}
