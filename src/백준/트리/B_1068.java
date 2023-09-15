package 백준.트리;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1068 {
    static int N, R, removeNode;
    static int leaf;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();   // 부모노드

            if (n != -1) {
                tree[n].add(i);
            } else {
                R = i;
            }
        }

        removeNode = sc.nextInt();   // 제거할 노드
        leaf = 0;
        visited = new boolean[N];

        if (removeNode == R) {
            System.out.println(0);
        } else {
            dfs(R);
//            DFS(R);
            System.out.println(leaf);
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        int cNode = 0;  // 현재노드의 자식노드의 개수

        for (int next : tree[node]) {
            if (!visited[next] && next != removeNode) {
                cNode++;
                dfs(next);
            }
        }

        if (cNode == 0) {
            leaf++;
        }
    }

    public static void DFS(int node) {
        visited[node] = true;

        if (tree[node].isEmpty()) {
            leaf++;
        }

        for (int next : tree[node]) {
            if (!visited[next] && next != removeNode) {
                DFS(next);
            }
        }
    }
}
