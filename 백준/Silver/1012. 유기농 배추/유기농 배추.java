import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());  // 가로
            N = Integer.parseInt(st.nextToken());  // 세로
            int K = Integer.parseInt(st.nextToken());  // 위치의 개수

            arr = new int[M][N];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());

                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                arr[i][j] = 1;
            }

            int cnt = 0;
            visited = new boolean[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        visited[i][j] = true;
                        DFS(i, j);
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nX = i + dx[k];
            int nY = j + dy[k];

            if (nX >= 0 && nX < M && nY >= 0 && nY < N) {
                if (!visited[nX][nY] && arr[nX][nY] == 1) {
                    visited[nX][nY] = true;
                    DFS(nX, nY);
                }
            }
        }
    }
}