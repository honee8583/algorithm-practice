package 백준;

// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
// 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
// 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

// 입력 : 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000),
// 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
// 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
// 출력 : 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
// V부터 방문된 점을 순서대로 출력하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 시작 정점

        // 인접리스트 구성
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a - 1).add(b);
            list.get(b - 1).add(a);
            Collections.sort(list.get(a - 1));
            Collections.sort(list.get(b - 1));
        }

        // dfs
        boolean[] visited = new boolean[N + 1];
        List<Integer> result = new ArrayList<>();
        dfs(list, visited, result, V);
        for (int r : result) {
            System.out.print(r + " ");
        }
        System.out.println();

        // bfs
        visited = new boolean[N + 1];
        result = new ArrayList<>();
        bfs(list, visited, result, V);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static void dfs(List<List<Integer>> list, boolean[] visited, List<Integer> result, int next) {
        if (visited[next]) {
            return;
        }

        visited[next] = true;
        result.add(next);

        List<Integer> nextList = list.get(next - 1);
        for (int num : nextList) {
            dfs(list, visited, result, num);
        }
    }

    public static void bfs(List<List<Integer>> list, boolean[] visited, List<Integer> result, int next) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(next);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (!visited[x]) {
                visited[x] = true;
                result.add(x);

                List<Integer> nextList = list.get(x - 1);
                if (nextList.size() > 0) {
                    for (int y : nextList){
                        queue.add(y);
                    }
                }
            }
        }
    }
}
