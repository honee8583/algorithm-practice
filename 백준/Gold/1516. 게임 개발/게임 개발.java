import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = parse(br.readLine());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        int[] times = new int[N + 1];
        for (int i = 1;i <= N;i++) {
            st = new StringTokenizer(br.readLine());
            int time = parse(st.nextToken());
            times[i] = time;

            while (true) {
                int num = parse(st.nextToken());
                if (num == -1) {
                    break;
                }
                adj.get(num).add(i);
                indegree[i]++;
            }
        }

        // System.out.println(Arrays.toString(indegree));
        // System.out.println(Arrays.toString(times));

        int[] result = new int[N + 1];
        for (int i = 1;i <= N;i++) {
            result[i] = 0;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N;i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        // System.out.println(Arrays.toString(result));

        while (!q.isEmpty()) {
            int cur = q.poll();

            result[cur] += times[cur];
            
            for (int next : adj.get(cur)) {
                result[next] = Math.max(result[next], result[cur]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }

            // System.out.println(Arrays.toString(result));
        }

        for (int i = 1;i <= N;i++) {
            System.out.println(result[i]);
        }
    }

    public static Integer parse(String token) {
        return Integer.parseInt(token);
    }
}