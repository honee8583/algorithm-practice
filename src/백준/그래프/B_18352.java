package 백준.그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B_18352 {
    static int N, M, K, X;
    static List<List<Integer>> adj;
    static int[] visited;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 도시의 개수
        M = sc.nextInt();   // 도로의 개수
        K = sc.nextInt();   // 최단 거리
        X = sc.nextInt();   // 출발 도시의 번호

        // 인접리스트 초기화
        adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 구성
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj.get(a).add(b);
        }

        // 방문 배열 초기화
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            visited[i] = -1;
        }

        BFS(X);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            if (visited[i] == K) {
                result.add(i);
            }
        }

        Collections.sort(result);

        if (result.size() > 0) {
            for (int  r : result) {
                System.out.println(r);
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s]++;   // 시작값은 0으로

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj.get(cur)) {
                if (visited[next] == -1) {  // 방문을 하지 않았을 경우
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
