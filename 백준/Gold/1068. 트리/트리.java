import java.io.*;
import java.util.*;

class Main {
    static int N, T, ROOT, cnt;
    static int[] parent;
    static boolean[] visited;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        for (int i = 0;i < N;i++) {
            adj.add(new ArrayList<>());
        }

        // 부모 배열 구성
        parent = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0;i < N;i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                ROOT = i;
            }
        }

        // 노드 제거
        T = Integer.parseInt(br.readLine());
        if (T == ROOT) {
            System.out.println(0);
            return;
        }
        parent[T] = Integer.MAX_VALUE;

        // System.out.println(Arrays.toString(parent));

        // 인접리스트 구성
        for (int i = 0;i < N;i++) {
            if (parent[i] != Integer.MAX_VALUE && parent[i] != -1) {
                adj.get(parent[i]).add(i);
            }
        }

        // for (int node : adj.get(ROOT)) {
        //     System.out.print(node + " ");
        // }
        // System.out.println();

        visited = new boolean[N];
        visited[ROOT] = true;
        cnt = 0;
        DFS(ROOT);

        System.out.println(cnt);
    }

    private static void DFS(int node) {
        List<Integer> nextNodes = adj.get(node);
        if (nextNodes.size() == 0) {
            cnt++;
            return;
        }

        for (int next : nextNodes) {
            if (!visited[next]) {
                visited[next] = true;
                DFS(next);
            }
        }
    }
}