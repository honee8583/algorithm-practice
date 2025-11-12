import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Edge> edgeList;
    static class Edge {
        int start;
        int end;
        int weight;
    
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 에지리스트 구성
        edgeList = new ArrayList<>();
        for (int i = 0;i < M;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(s, e, w));
        }

        // 거리 배열(정답 배열)
        long[] dist = new long[N + 1];
        dist[1] = 0;
        for (int i = 2;i <= N;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0;i < N - 1;i++) {  // N - 1만큼 반복
            for (Edge edge : edgeList) {    // 에지리스트를 반복
                int s = edge.start;
                int e = edge.end;
                int w = edge.weight;

                if (dist[s] != Integer.MAX_VALUE && dist[e] > dist[s] + w) {
                    dist[e] = dist[s] + w;
                }
            }
        }

        // 음수 사이클 확인
        boolean isCycle = false;
        for (Edge edge : edgeList) {    // 에지리스트를 반복
            int s = edge.start;
            int e = edge.end;
            int w = edge.weight;

            if (dist[s] != Integer.MAX_VALUE && dist[e] > dist[s] + w) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            for (int i = 2;i <= N;i++) {
                if (dist[i] != Integer.MAX_VALUE) {
                    System.out.println(dist[i]);
                } else {
                    System.out.println("-1");
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}