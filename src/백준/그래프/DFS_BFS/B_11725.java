package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_11725 {
    static boolean[] visited;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bf.close();

        map = new HashMap<>();
        visited = new boolean[N + 1];

        dfs(list, 1);

        for (int i = 2; i <= N; i++) {
            System.out.println(map.get(i));
        }
    }

    public static void dfs(List<List<Integer>> list, int cur) {
        if (visited[cur]) {
            return;
        }

        visited[cur] = true;

        List<Integer> nodeList = list.get(cur);
        for (int n : nodeList) {
            if (!visited[n]) {
                map.put(n, cur);
                dfs(list, n);
            }
        }
    }
}
