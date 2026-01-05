import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[N + 1];
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int A = parseInt(st.nextToken());
            int B = parseInt(st.nextToken());
            adj.get(A).add(B);
            indegree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1;i <= N;i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);

            for (int next : adj.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    public static Integer parseInt(String num) {
        return Integer.parseInt(num);
    }
}