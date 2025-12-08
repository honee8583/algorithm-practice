import java.io.*;
import java.util.*;

class Main {
    static final int ROOT = 1;
    static int N, M, K;
    static int[] depths;
    static boolean[] visited;
    static int[][] P;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0;i < N - 1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 2^k < 트리의 깊이를 만족하는 k의 최댓값 구하기
        int temp = 1;
        K = 0;
        while (temp <= N) {
            temp *= 2;
            K++;
        }

        P = new int[K + 1][N + 1];
        
        // 깊이 배열 및 2^0부모 노드 구성하기
        depths = new int[N + 1];
        visited = new boolean[N + 1];
        DFS(ROOT);
        
        // 2^k 부모노드 구성하기
        for (int k = 1;k <= K;k++) {
            for (int i = 1;i <= N;i++) {
                P[k][i] = P[k - 1][P[k - 1][i]];
            }
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a, b));
        }
    }

    // 부모 노드 구하기
    private static void DFS(int node) {
        visited[node] = true;
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                depths[next] = depths[node] + 1;
                P[0][next] = node;
                DFS(next);
            }
        }
    }

    private static int LCA(int a, int b) {
        if (depths[a] > depths[b]) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        // 두 노드의 깊이 맞추기 (b를 올린다)
        for (int k = K;k >= 0;k--) {
            // 2^k가 깊이 차이보다 작아야만 2^k 단위로 움직일 수 있다
            if (Math.pow(2, k) <= depths[b] - depths[a]) {
                // b의 2^k번째 부모노드의 깊이가 a노드의 깊이보다 깊을 때(=b가 a보다 아래에 있을 때)
                if (depths[a] <= depths[P[k][b]]) {
                    b = P[k][b];
                }
            }
        }

        // k를 줄여나가면서 같은 부모노드를 갖고 있는지 확인
        for (int k = K;k >= 0;k--) {
            if (P[k][a] != P[k][b]) {
                a = P[k][a];
                b = P[k][b];
            }
        }

        // 마지막에  a!=b라면 그의 부모노드가 LCA이다
        int LCA = a;
        if (a != b) {
            LCA = P[0][LCA];
        }

        return LCA;
    }
}