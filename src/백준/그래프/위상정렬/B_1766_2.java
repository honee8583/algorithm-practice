package 백준.그래프.위상정렬;

import java.io.*;
import java.util.*;

public class B_1766_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] d = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj.get(A).add(B);
            d[B] += 1;
        }

        while (true) {
            int node = -1;
            for (int i = 1; i <= N; i++) {
                if (d[i] == 0) {
                    node = i;
                    d[i] = -1;
                    break;
                }
            }

            if (node == -1) {
                break;
            }

            bw.write(node + " ");

            for (int next : adj.get(node)) {
                d[next]--;
            }
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
