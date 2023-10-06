package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1520 {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    static int M;
    static int N;
    static int cnt;
    static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 배열구성
        matrix = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  // 결과 배열은 -1로 구성
            }
        }

        bf.close();

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int i, int j) {
        if (i == M - 1 && j == N - 1) { // 끝에 도착했을 경우
            return 1;
        }

        // 이미 탐색해서 경로의 개수가 파악된 지점을 또 탐색하게 되면, 저장된 경로의 개수를 반환하면 된다.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < M && y < N) {
                if (matrix[x][y] < matrix[i][j]) {
                    dp[i][j] += dfs(x, y);
                }
            }
        }

        return dp[i][j];
    }
}
