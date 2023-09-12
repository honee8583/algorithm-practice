package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2623 {
    static int N, M;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> nList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                nList.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < nList.size() - 1; j++) {
                int n1 = nList.get(j);
                int n2 = nList.get(j + 1);

                list.get(n1).add(n2);
                indegree[n2]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            result.add(cur);

            for (int next : list.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] != 0) {
                System.out.println(0);
                flag = false;
                break;
            }
        }

        if (flag) {
            for (int r : result) {
                System.out.println(r);
            }
        }
    }
}
