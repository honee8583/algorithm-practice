import java.io.*;
import java.util.*;

class Main {
    static boolean[][] visited;
    static int[][] map;
    static int num;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(str[j]);
                map[i][j + 1] = cur;
            }
        }

        num = 1;
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    DFS(i, j);
                    num++;
                }
            }
        }
        num -= 1;

        System.out.println(num);

        int[] result = new int[num];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int target = map[i][j];
                if (target != 0) {
                    result[target - 1]++;
                }
            }
        }

        Arrays.sort(result);
        for (int i = 0; i < num; i++) {
            bw.write(result[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int i, int j) {
        visited[i][j] = true;
        map[i][j] = num;

        for (int k = 0; k < 4; k++) {
            int nX = i + dx[k];
            int nY = j + dy[k];

            if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
                if (map[nX][nY] != 0 && !visited[nX][nY]) {
                    DFS(nX, nY);
                }
            }
        }
    }
}