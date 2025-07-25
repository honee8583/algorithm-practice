import java.io.*;
import java.util.*;

class Main {
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    static int N;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }

        int cnt;
        int result = Integer.MIN_VALUE;
        for (int rain = 0; rain <= max; rain++) {
            cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > rain) {
                        DFS(i, j, rain);
                        cnt++;
                    }
                }
            }
            result = Math.max(cnt, result);
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int x, int y, int rain) {
        if (!visited[x][y] && arr[x][y] > rain) {
            visited[x][y] = true;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (nX >= 0 && nX < N && nY >= 0 && nY < N) {
                if (!visited[nX][nY] && arr[nX][nY] > rain) {
                    DFS(nX, nY, rain);
                }
            }
        }
    }
}