package programmers;

import java.util.ArrayList;

public class 네트워크 {

    public static void solution(int n, int[][] computers) {
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접리스트 구성
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (computers[i][j] == 1 && i != j) {
                    list[i].add(j);
                }
            }
        }

        // 방문배열 구성
        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                DFS(list, visited, i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(ArrayList<Integer>[] list, boolean[] visited, int p) {
        if (visited[p]) {
            return;
        }

        visited[p] = true;

        for (int a : list[p]) {
            if (!visited[a]) {
                DFS(list, visited, a);
            }
        }
    }

    public static void main(String[] args) {
        solution(3, new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1}});   // 2
        solution(3, new int[][]{new int[]{1,1,0}, new int[]{1,1,1}, new int[]{0,1,1}});
    }
}
