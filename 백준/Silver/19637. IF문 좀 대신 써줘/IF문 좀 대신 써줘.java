import java.io.*;
import java.util.*;

class Main {
    static int[] scores;
    static String[] chinghos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        scores = new int[N + 1];
        scores[0] = 0;
        chinghos = new String[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String chingho = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            scores[i] = score;
            chinghos[i] = chingho;
        }
        chinghos[0] = chinghos[1];

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            binarySearch(target);
        }
    }

    // 0
    // 0    10000 100000 1000000
    // null WEAK  NORMAl STRONG
    public static void binarySearch(int target) {
        int start = 0;
        int end = scores.length - 1; // 3
        while (start <= end) { // 0
            int midIdx = (start + end) / 2;

            if (target <= scores[midIdx]) {
                end = midIdx - 1;
            } else {
                start = midIdx + 1;
            }
        }

        System.out.println(chinghos[start]);
    }
}