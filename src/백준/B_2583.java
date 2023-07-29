package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2583 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {-1, 1, 0, 0};

    static int M;
    static int N;

    static int[][] matrix;
    static boolean[][] visited;
    static int cnt;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2차원 배열 구성
        matrix = new int[M][N];
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(bf.readLine());

            int leftDown1 = Integer.parseInt(st.nextToken());
            int leftDown2 = Integer.parseInt(st.nextToken());
            int rightTop1 = Integer.parseInt(st.nextToken());
            int rightTop2 = Integer.parseInt(st.nextToken());

            for (int k = M - rightTop2; k < M - leftDown2; k++) {
                for (int l = leftDown1; l < rightTop1; l++) {
                    matrix[k][l] = 1;
                }
            }
        }

        visited = new boolean[M][N];
        cnt = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    dfs(i, j);
                    cnt++;  // 영역개수 증가
                    result.add(total);
                    total = 0;
                }
            }
        }

        System.out.println(cnt);
        Collections.sort(result);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static void dfs(int i, int j) {
        if (visited[i][j]) {
            return;
        }

        total++;
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < M && y >= 0 && y < N) {
                if (!visited[x][y] && matrix[x][y] == 0) {
                    dfs(x, y);
                }
            }
        }
    }
}
