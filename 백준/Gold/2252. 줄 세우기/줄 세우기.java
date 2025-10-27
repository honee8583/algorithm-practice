import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> adj;
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parse(st.nextToken());
        M = parse(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0;i <= N;i++) {
            adj.add(new ArrayList<>());
        }

        // 인접리스트 및 진입차수 배열 구성
        arr = new int[N + 1];
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = parse(st.nextToken());
            int b = parse(st.nextToken());

            adj.get(a).add(b);
            arr[b] += 1;
        }

        // 진입차수가 0인 노드를 선택
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N;i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }

        // 진입차수가 0인 노드의 인접노드의 진입차수 - 1
        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next : adj.get(cur)) {
                arr[next]--;
                if (arr[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }

    public static Integer parse(String num) {
        return Integer.parseInt(num);
    }
}