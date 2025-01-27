package 백준.그래프.위상정렬;

import java.io.*;
import java.util.*;

public class B_2252_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 학생 수
        int M = Integer.parseInt(st.nextToken());  // 비교 횟수

        // 위상정렬은 사이클이 없는 방향 그래프에서 사용.
        // 순서가 있으므로 방향이 없고 사이클 또한 존재할 수 없음.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] d = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // A가 B보다 앞에 서야함
            adj.get(A).add(B);
            d[B] += 1;
        }

        while (true) {
            // 진입차수가 0인 노드를 선택
            int cur = -1;
            for (int i = 1; i <= N; i++) {
                if (d[i] == 0) {
                    cur = i;
                    d[i] = -1;
                    break;
                }
            }

            if (cur == -1) {
                break;
            }

            bw.write(cur + " ");

            // 선택한 노드의 인접한 노드의 진입차수를 1씩 감소
            for (int next : adj.get(cur)) {
                d[next]--;
            }
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
