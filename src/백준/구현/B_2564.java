package 백준.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_2564 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int store = Integer.parseInt(br.readLine());

        int result = 0;
        int total = (width + height) * 2;
        int[] dists = new int[store];
        for (int i = 0; i <= store; i++) {
            st = new StringTokenizer(br.readLine());
            int way = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            int tmp = 0;
            switch (way) {
                case 1:
                    tmp = distance;
                    break;
                case 2:
                    tmp = width + height + width - distance;
                    break;
                case 3:
                    tmp = width + height + width + height - distance;
                    break;
                case 4:
                    tmp = width + distance;
                    break;
            };

            if (i != store) {
                dists[i] = tmp;
            } else {
                for (int j = 0; j < store; j++) {
                    int diff = Math.abs(dists[j] - tmp);
                    result += Math.min(diff, total - diff);
                }
            }
        }

        bw.write(result +"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
