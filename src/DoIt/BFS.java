package DoIt;

// 백준 온라인 저지 2178번
// 난이도 : 실버1
// 시간 제한 : 1초

// N×M크기의 배열로 표현되는 미로가 있다.
// 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
// 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
// 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
// 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

// 입력 : 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다.
// 각각의 수들은 붙어서 입력으로 주어진다.
// 출력 : 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    // 상하좌우 이동을 위한 좌표
    static final int[] dx = {0,1,0,-1};
    static final int[] dy = {1,0,-1,0};
    static int N;
    static int M;

    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[N][M];
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
//                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
                arr[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        BFS(arr, visited, 0, 0);

        System.out.println(arr[N-1][M-1]);
    }

    public static void BFS(int[][] arr, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k]; // 다음 x좌표
                int y = now[1] + dy[k]; // 다음 y좌표
                if (x >= 0 && y >= 0 && x < N && y < M) {  // 다음 방문할 곳이 전체 배열의 범위를 넘어가면 안됨
                    if (arr[x][y] != 0 && !visited[x][y]) {   // 다음 방문할 곳이 0이 아니고 아직 방문하지 않은 곳일경우 방문
                        visited[x][y] = true;
                        arr[x][y] =  arr[now[0]][now[1]] + 1; // 다음 방문한 곳에 깊이를 넣어준다.
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
