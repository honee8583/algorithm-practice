package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {
    static int N, M;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String[] strings = st.nextToken().split("");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(strings[j]);
            }
        }

        visited[0][0] = true;
        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    public static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] idx = q.poll();

            for (int k = 0; k < 4; k++) {
                int nextX = idx[0] + dx[k];
                int nextY = idx[1] + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (!visited[nextX][nextY] && A[nextX][nextY] != 0) {
                        A[nextX][nextY] = A[idx[0]][idx[1]] + 1;
                        visited[nextX][nextY] = true;
                        q.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
