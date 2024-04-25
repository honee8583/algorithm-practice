package 백준.트리.기본;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1068 {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int delNode, leafCnt, root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 자식리스트(단방향 인접리스트)
        tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        // 입력
        for (int i = 0; i < N; i++) {
            int parent = sc.nextInt();

            if (parent != -1) {
                tree[parent].add(i);
            } else {
                root = i;
            }
        }

        delNode = sc.nextInt(); // 삭제할 노드 번호
        leafCnt = 0;
        visited = new boolean[N];
        DFS(root);

        // 출력
        if (delNode == root) {
            System.out.println("0");
        } else {
            System.out.println(leafCnt);
        }
    }

    // 삭제할 노드부터는 세지 않는다.
    public static void DFS(int node) {
        visited[node] = true;

        int leafNodes = 0;
        for (int next : tree[node]) {
            if (!visited[next] && next != delNode) {
                leafNodes++;
                DFS(next);
            }
        }

        // 탐색한 자식노드의 개수가 0이 아니면 리프노드가 아니다
        if (leafNodes == 0) {
            leafCnt++;
        }
    }
}
