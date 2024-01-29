package 백준.그래프.위상정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_2252_2 {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] inDegrees; // 진입차수 배열
    static boolean[] visited;
    static Queue<Integer> queue;
    static ArrayList<Integer> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        adj = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adj[i] = new ArrayList<>();
        }

        inDegrees = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            adj[a].add(b);
            inDegrees[b]++;
        }

        System.out.println(Arrays.toString(inDegrees));

        visited = new boolean[N + 1];
        result = new ArrayList<>();

        updateDegrees();

        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static void updateDegrees() {
        queue = new LinkedList<>();
        insertQueue();

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : adj[cur]) {
                inDegrees[next]--;
            }

            insertQueue();
        }
    }

    public static void insertQueue() {
        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0 && !visited[i]) {
                queue.add(i);
                result.add(i);
                visited[i] = true;
                break;
            }
        }   // 큐 입력
        System.out.println(queue);
    }
}
