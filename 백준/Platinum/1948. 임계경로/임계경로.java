import java.io.*;
import java.util.*;

class Main {
    static int N, M, S, E;
    static List<List<Integer>> adj, rAdj;
    static int[][] times;
    static int[] indegree;
    static int[] cp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = parse(br.readLine());
        M = parse(br.readLine());

        adj = new ArrayList<>();  // 정방향
        rAdj = new ArrayList<>(); // 역방향
        for (int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
            rAdj.add(new ArrayList<>());
        }

        indegree = new int[N + 1];  // 진입차수 배열
        times = new int[N + 1][N + 1];
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());

            int start = parse(st.nextToken());
            int end = parse(st.nextToken());
            int time = parse(st.nextToken());

            // 시간배열
            times[start][end] = time;

            // 인접리스트
            adj.get(start).add(end);
            
            // 역방향 인접리스트
            rAdj.get(end).add(start);

            indegree[end]++;
        }

        st = new StringTokenizer(br.readLine());
        S = parse(st.nextToken());
        E = parse(st.nextToken());

        int time = getResult();
        int cnt = reverseSearch();

        System.out.println(time);
        System.out.println(cnt);

    }

    private static int getResult() {
        cp = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1;i <= N;i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int next : adj.get(node)) {
                cp[next] = Math.max(cp[next], cp[node] + times[node][next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return cp[E];
    }

    private static int reverseSearch() {
        Queue<Integer> q = new LinkedList<>();
        q.add(E);

        boolean[] visited = new boolean[N + 1];
        visited[E] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : rAdj.get(cur)) {
                if (cp[cur] == cp[next] + times[next][cur]) {
                    cnt++;
                    if (!visited[next]) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }
        }

        return cnt;
    }

    private static int parse(String token) {
        return Integer.parseInt(token);
    }
}