package 백준.그래프.DFS_BFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1012 {
    static BufferedReader bf;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int M, N, K;
    static int[][] arr;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            solution();
        }
    }

    public static void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());   // 가로길이
        N = Integer.parseInt(st.nextToken());   // 세로길이
        K = Integer.parseInt(st.nextToken());   // 배추개수

        arr = new int[N][M];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x][y] = 1;
        }

        answer = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (!visited[nextX][nextY] && arr[nextX][nextY] == 1) {
                    DFS(nextX, nextY);
                }
            }
        }
    }
}
