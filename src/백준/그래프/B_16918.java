package 백준.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16918 {
    static int R, C, N;
    static int[][] bombs;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        bombs = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                String num = s[j];
                if (num.equals(".")) {
                    bombs[i][j] = -1;   // 폭탄 x
                } else {
                    bombs[i][j] = 0;    // 폭탄
                }
            }
        }

        // 초기상태 (1초 동안 아무일도 없음)
        int time = 1;
        while (true) {
            if (time == N) break;

            // 1. 빈칸에 폭탄 설치 (숫자 2로 업데이트) - 반복문
            time++;
            install_bombs(time);    // 현재시간 : 새로 설치한 폭탄, 1 : 기존 폭탄, -1 : 비어있음
            if (time == N) break;

            // 2. 3초전에 설치한 폭탄 터뜨리기 - DFS/BFS (0에 해당하는 부분 터뜨리기)
            time++;
            bomb(time);
            if (time == N) break;
        }

        // 출력
        printBombs();
    }

    private static void printBombs() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombs[i][j] == -1) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    // 비어있는 곳에 폭탄 설치
    private static void install_bombs(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombs[i][j] == -1) {    // 비어있을 경우
                    bombs[i][j] = time;    // 폭탄 설치 (걸린 시간)
                }
            }
        }
    }

    // 기존 폭탄 터뜨리기(상,하,좌,우 포함)
    private static void bomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombs[i][j] == (time - 3)) {  // 현재 걸린시간에서 3초전에 설치한 폭탄 터뜨리기
                    bombs[i][j] = -1;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (nextX >= 0 && nextY >= 0 && nextX < R && nextY < C && bombs[nextX][nextY] != (time - 3)) {
                            bombs[nextX][nextY] = -1;
                        }
                    }
                }
            }
        }
    }
}
