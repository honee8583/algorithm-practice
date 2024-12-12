package 백준.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Game {
    int star;
    int circle;
    int rectangle;
    int triangle;
}

public class B_14696 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Game A = createGame(st);

            st = new StringTokenizer(br.readLine());
            Game B = createGame(st);

            startGame(A, B, bw);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void startGame(Game A, Game B, BufferedWriter bw) throws IOException {
        if (A.star != B.star) {
            bw.write(A.star > B.star ? "A" : "B");
            bw.write("\n");
        } else if (A.circle != B.circle) {
            bw.write(A.circle > B.circle ? "A" : "B");
            bw.write("\n");
        } else if (A.rectangle != B.rectangle) {
            bw.write(A.rectangle > B.rectangle ? "A" : "B");
            bw.write("\n");
        } else if (A.triangle != B.triangle) {
            bw.write(A.triangle > B.triangle ? "A" : "B");
            bw.write("\n");
        } else {
            bw.write("D");
            bw.write("\n");
        }
    }

    private static Game createGame(StringTokenizer st) {
        int cnt = Integer.parseInt(st.nextToken());
        Game game = new Game();
        for (int k = 0; k < cnt; k++) {
            int num = Integer.parseInt(st.nextToken());
            insert(num, game);
        }
        return game;
    }

    private static void insert(int num, Game game) {
        switch(num) {
            case 4:
                game.star++;
                break;
            case 3:
                game.circle++;
                break;
            case 2:
                game.rectangle++;
                break;
            case 1:
                game.triangle++;
                break;
        }
    }
}
