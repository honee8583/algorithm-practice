package 백준;

import java.util.Scanner;

public class B_1976 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열 초기화
        arr = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        int[][] cities = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                cities[i][j] = sc.nextInt();
            }
        }

        // 도시 연결
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cities[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] tripList = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            tripList[i] = sc.nextInt();
        }

        int idx = find(tripList[1]);
        for (int i = 2; i < tripList.length; i++) {
            if (idx != find(tripList[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            arr[j] = i;
        }
    }

    // 대표노드의 자식노드들의 값을 대표노드로 변경
    public static int find(int node) {
        if (arr[node] == node) {
            return node;
        }

        return arr[node] = find(arr[node]);
    }
}
