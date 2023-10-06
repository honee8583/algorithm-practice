package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2667 {
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    static int cnt = 0;
    static int number = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String[] sArr = st.nextToken().split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(sArr[j]);
            }
        }

        boolean[][] visited = new boolean[N][N];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 아직 방문하지 않았고 값이 1인 곳에서 dfs 시작
                if (!visited[i][j] && matrix[i][j] == 1) {
                    cnt = 0;    // 각 단지 개수 초기화
                    number++;   // 단지 번호 증가
                    dfs(matrix, visited, i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int a : list) {
            System.out.println(a);
        }

        bf.close();
    }

    public static void dfs(int[][] matrix, boolean[][] visited, int i, int j) {
        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        matrix[i][j] = number;
        cnt++;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix.length) {
                if (!visited[x][y] && matrix[x][y] == 1) {  // 다음 방문할 곳이 방문하지 않았고 값이 1인경우
                    matrix[x][y] = number;

                    dfs(matrix, visited, x, y);
                }
            }
        }
    }
}
