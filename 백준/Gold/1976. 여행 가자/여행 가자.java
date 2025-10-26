import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
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

//        System.out.println(Arrays.deepToString(matrix));
//        System.out.println(Arrays.toString(route));

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (matrix[i][j] == 1) {
                    union(i, j);
                }
            }
        }

//        System.out.println(Arrays.toString(parent));

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

//        if (startParent >= endParent) {
//            parent[endParent] = startParent;
//        } else {
//            parent[startParent] = endParent;
//        }

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
