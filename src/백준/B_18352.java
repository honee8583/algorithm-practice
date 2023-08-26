package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_18352 {
    static int N;
    static int M;
    static int K;
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   // 도시의 개수
        M = Integer.parseInt(st.nextToken());   // 도로의 개수
        K = Integer.parseInt(st.nextToken());   // 최단 거리
        X = Integer.parseInt(st.nextToken());   // 출발 도시의 번호

        // 인접리스트 구성
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        List<Integer> result = new ArrayList<>();
        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);

        BFS(list, visited, X, 0);

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int a : result) {
                System.out.println(a);
            }
        }
    }

    public static void BFS(List<List<Integer>> list, int[] visited, int city, int distance) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        visited[city]++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i : list.get(cur)) {
                if (visited[i] == -1) {  // 아직 방문하지 않았을 경우 거리값 갱신 및 큐에 인접리스트 추가
                    visited[i] = visited[cur] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
