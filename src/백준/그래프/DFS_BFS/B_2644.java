package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_2644 {
    static int N;
    static int M;
    static int result = -1;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   // 전체 사람의 수

        st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());   // 타겟1
        int b = Integer.parseInt(st.nextToken());   // 타겟2

        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken());       // 간선의 수

        // 인접리스트
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(list, a, b, 0);

        System.out.println(result);
    }

    public static void dfs(List<List<Integer>> list, int cur, int target, int cnt) {
        if (cur == target) {
            result = cnt;
            return;
        }

        if (visited[cur]) {
            return;
        }

        visited[cur] = true;

        List<Integer> targetList = list.get(cur);
        for (int t : targetList) {
            if (!visited[t]) {
                dfs(list, t, target, cnt + 1);
            }
        }
    }
}
