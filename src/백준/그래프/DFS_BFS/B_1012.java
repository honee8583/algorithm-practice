package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1012 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static int[][] matrix;
    static boolean[][] visited;
    static int cnt;
    static int T;
    static int M;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());   // 테스트 케이스 수

        for (int i = 0; i < T; i++) {
            cnt = 0;

            st = new StringTokenizer(bf.readLine(), " ");
            M = Integer.parseInt(st.nextToken());   // 가로
            N = Integer.parseInt(st.nextToken());   // 세로
            K = Integer.parseInt(st.nextToken());   // 심어져있는 배추의 개수

            // 배추가 있는곳에 1 삽입
            matrix = new int[N][M];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
//                System.out.println("(" + a + ", " + b + ")");

                matrix[b][a] = 1;
            }

            visited = new boolean[N][M];

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (matrix[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int i, int j) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < N && y >= 0 && y < M) {
                if (matrix[x][y] == 1 && !visited[x][y]) {
                    dfs(x, y);
                }
            }
        }
    }
}
