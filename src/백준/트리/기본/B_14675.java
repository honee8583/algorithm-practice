package 백준.트리.기본;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 단절점과 단절선
public class B_14675 {
    static int N, Q;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());

        // 인접리스트
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        Q = Integer.parseInt(bf.readLine());
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (t == 1) {   // 인접리스트의 정점 개수가 2개 이상일경우 단절점
                if (adj.get(k).size() >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else if (t == 2) {   // 간선을 없앨경우 무조건 단절선
                System.out.println("yes");
            }
        }
    }
}
