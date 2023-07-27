package 백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_2606 {
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[N + 1];

        dfs(list, visited, 1);

        System.out.println(cnt - 1);
    }

    public static void dfs(List<List<Integer>> list, boolean[] visited, int start) {
        if (visited[start]) {
            return;
        }

        List<Integer> nextList = list.get(start);
        visited[start] = true;
        cnt++;

        for (int n : nextList) {
            dfs(list, visited, n);
        }
    }
}
