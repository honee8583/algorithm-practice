package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1926 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int size;

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        size = 0;
        int cnt = 0;
        int max = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    DFS(i, j);
                    cnt++;
                    max = Math.max(max, size);
                    size = 0;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max);
    }

    private static void DFS(int x, int y) {
        size += 1;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                if (arr[nX][nY] == 1 && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    DFS(nX, nY);
                }
            }
        }
    }
}
