package 백준.그래프;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B_2668 {
    static int N;
    static int[] graph;
    static List<Integer> list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            visited[i] = true;
            DFS(i, i);
        }

        Collections.sort(list);
        bw.write(list.size() + "\n");
        for (int r : list) {
            bw.write(r + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void DFS(int node, int target) {
        if (!visited[graph[node]]) {
            visited[graph[node]] = true;
            DFS(graph[node], target);
        }

        if (graph[node] == target) list.add(target);
    }
}
