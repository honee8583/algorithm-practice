import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = getNum(br.readLine());
        int M = getNum(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1;j <= N; j++) {
                boolean isConnected = getNum(st.nextToken()) == 1;
                if (isConnected) {
                    union(i, j);
                }
            }
        }

        int[] route = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < M;i++) {
            route[i] = getNum(st.nextToken());
        }

        int node = find(route[0]);
        boolean flag = true;
        for (int i = 1;i < M;i++) {
            if (find(route[i]) != node) {
                flag = false;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[a] = b;
        }
    }

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static Integer getNum(String token) {
        return Integer.parseInt(token);
    }
}