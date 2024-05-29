package 백준.그래프.DFS_BFS;

import java.io.*;
import java.util.*;

public class B_16234 {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(arr));

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                BFS(i, j);
            }
        }


    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int day = 0;
        int count = 0;
        List<int[]> arrayList = new ArrayList<>();
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int X = cur[0];
            int Y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextX = X + dx[i];
                int nextY = Y + dy[i];

                int diff = Math.abs(arr[nextX][nextY] - arr[X][Y]);

                if (!visited[nextX][nextY] && diff >= L && diff <= R) {
                    visited[nextX][nextY] = true;
                    count++;
                    arr[X][Y] += arr[nextX][nextY];
                    q.add(new int[]{nextX, nextY});
                }
            }

            day++;
        }
    }
}
