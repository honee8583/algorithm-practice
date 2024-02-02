package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1516_2 {
    static int N;
    static int[] answer, inDegree, timeArr;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }   // 인접리스트 구성

        inDegree = new int[N + 1];
        timeArr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            timeArr[i] = time;
            while (st.hasMoreTokens()) {
                int adjBuilding = Integer.parseInt(st.nextToken());
                if (adjBuilding == -1) {
                    break;
                }
                adj[adjBuilding].add(i);
                inDegree[i]++;
            }
        }

//        System.out.println("진입차수배열 : " + Arrays.toString(inDegree));

        topologicalSorting();

        for (int i = 1; i <= N; i++) {
            answer[i] += timeArr[i];
            System.out.println(answer[i]);
        }
    }

    public static void topologicalSorting() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        answer = new int[N + 1];
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                answer[next] = Math.max(answer[cur] + timeArr[cur], answer[next]);

                inDegree[next]--;

                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}
