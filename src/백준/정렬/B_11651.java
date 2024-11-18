package 백준.정렬;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11651 {
    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.y > o.y) {
                return 1;
            } else if (this.y == o.y) {
                return this.x - o.x;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        Coordinate[] coordinates = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i] = new Coordinate(x, y);
        }

        Arrays.sort(coordinates);

        for (Coordinate c : coordinates) {
            System.out.println(c.x + " " + c.y);
        }
    }
}
