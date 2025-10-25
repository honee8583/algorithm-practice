import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int N, M, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            adj.get(S).add(E);
        }

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cnt = 1;
            visited = new boolean[N + 1];
            visited[i] = true;
            DFS(i);
            arr[i] = cnt;
        }

        // System.out.println(Arrays.toString(arr));

        int max = Arrays.stream(arr).max().getAsInt();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == max) {
                result.add(i);
            }
        }

        Collections.sort(result);
        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    static void DFS(int node) {
        for (int next : adj.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                cnt++;
                DFS(next);
            }
        }
    }
}