package 백준.백트래킹;

import java.util.Scanner;

public class B_15650 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N + 1];
        arr = new int[N + 1];
        dfs(0, 0);
    }

    private static void dfs(int depth, int pre) {
        if (depth == M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && i > pre) {
                visited[i] = true;
                arr[depth + 1] = i;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
