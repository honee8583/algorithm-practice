package 백준.그래프.유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1976_2 {
    static int N, M;
    static int[] route, parent;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        route = new int[M + 1];
        matrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connection = Integer.parseInt(st.nextToken());
                matrix[i][j] = connection;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 연결되어 있을 경우 union
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // 여행경로의 최상위노드가 모두 같을 경우 'Yes', 같지 않을 경우 'No'
        int start = find(route[1]);
        for (int i = 2; i < route.length; i++) {
            if (start != find(route[i])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int startPoint, int endPoint) {
        startPoint = find(startPoint);
        endPoint = find(endPoint);

        if (startPoint != endPoint) {
            parent[endPoint] = startPoint;
        }
    }

    public static int find(int point) {
        if (parent[point] == point) {
            return point;
        }

        return parent[point] = find(parent[point]);
    }
}
