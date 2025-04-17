package 백준.그래프.DFS_BFS;

import java.io.*;
import java.util.*;

public class B_2178_미로탐색하기 {
    static int N, M;
    static boolean[][] visited;
    static int[][] arr;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] str = line.split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        br.close();

        visited = new boolean[N][M];
        BFS();

        bw.write(arr[N - 1][M - 1] + "\n");
        bw.flush();
        bw.close();
    }

    private static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});  // 시작지점
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            System.out.println(cur[0] + ", " + cur[1]);

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                        // 다음 노드를 방문할 때마다 cnt를 증가하는 것이 아닌,
                        // 다음 노드의 값을 이전 노드보다 1 증가시키고
                        // 마지막 노드의 값을 출력
                        arr[x][y] = arr[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
    }
}
