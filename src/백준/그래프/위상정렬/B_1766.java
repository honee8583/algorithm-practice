package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_1766 {
    static int N, M;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인접리스트 구성
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            indegree[b]++;
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
            System.out.print(cur + " ");

            for (int n : list.get(cur)) {
                indegree[n]--;
                if (indegree[n] == 0) {
                    pq.offer(n);
                }
            }
        }
    }
}
