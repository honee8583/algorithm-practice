import java.io.*;
import java.util.*;

class Main {
    static int min;
    static int N;
    static int[][] S;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N + 1][N + 1];

        StringTokenizer st;
        for (int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        visited = new boolean[N + 1];
        DFS(0, 0);

        System.out.println(min);
    }

    private static void DFS(int node, int depth) {
        if (depth == N / 2) {
            diff();
            return;
        }

        for (int i = node + 1;i <= N ;i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void diff() {
        int teamA = 0;
        int teamB = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    teamA += S[i][j];
                    teamA += S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    teamB += S[i][j];
                    teamB += S[j][i];
                }
            }
        }

        int diff = Math.abs(teamA - teamB);

        if (diff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(min, diff);
    }
}