package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N + 1];    // 진입차수 배열
        int[] time = new int[N + 1];        // 소요시간 배열
        ArrayList<Integer>[] list = new ArrayList[N + 1];   // 인접리스트 배열
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 시간배열, 인접리스트 구성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());

                if (next == -1) {
                    break;
                } else {
                    list[next].add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] result = new int[N + 1];
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : list[cur]) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[cur] + time[cur]); // * 키포인트

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i] + time[i]);
        }
    }
}
