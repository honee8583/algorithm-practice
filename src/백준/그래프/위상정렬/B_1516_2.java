package 백준.그래프.위상정렬;

import java.io.*;
import java.util.*;

public class B_1516_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] D = new int[N + 1];   // 진입차수 배열
        int[] time = new int[N + 1];    // 최단거리 배열
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                } else {
                    // 인접리스트 구성 및 진입차수 배열 구성
                    adj.get(num).add(i);
                    D[i]++;
                }
            }
        }

        // 진입차수가 0인 인덱스로 시작
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (D[i] == 0) {
                q.add(i);
            }
        }

        int[] ans = new int[N + 1];
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj.get(cur)) {
                ans[next] = Math.max(ans[next], ans[cur] + time[cur]);
                D[next]--;

                // 진입차수가 0일경우 다시 추가
                if (D[next] == 0) {
                    q.add(next);
                }
            }
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(ans[i] + time[i]);
        }
    }
}
