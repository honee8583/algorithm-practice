import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        int cnt = BFS(0, 0);
        System.out.println(cnt);
    }

    private static int BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, 1});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == N - 1 && y == M - 1) {
                return cur[2];
            }

            for (int k = 0; k < 4; k++) {
                int nX = x + dx[k];
                int nY = y + dy[k];

                if (nX >= 0 && nX < N && nY >= 0 && nY < M) {
                    if (arr[nX][nY] == 1 && !visited[nX][nY]) {
                        visited[nX][nY] = true;
                        q.add(new int[]{nX, nY, cur[2] + 1});
                    }
                }
            }
        }

        return -1;
    }
}
