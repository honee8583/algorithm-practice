package 백준.그래프.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_13023 {
    static boolean result = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점
        int M = Integer.parseInt(st.nextToken());   // 간선

        List<List<Integer>> fs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            fs.add(new ArrayList<>());
        }

        // 인접리스트 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            fs.get(a).add(b);
            fs.get(b).add(a);
        }

        bf.close();

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];   // 방문배열 초기화
            dfs(fs, i, 1);  // 모든 정점에서 dfs 시작

            if (result) {
                break;
            }
        }

        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(List<List<Integer>> list, int cur, int cnt) {
        if (visited[cur]) {
            return;
        }

        if (cnt >= 5) {
            result = true;
            return;
        }

        visited[cur] = true;

        List<Integer> fsList = list.get(cur);
        for (int next : fsList) {
            if (!visited[next]) {
                dfs(list, next, cnt + 1);
                visited[next] = false;
            }
        }
        visited[cur] = false;   // 핵심
    }
}
