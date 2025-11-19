import java.io.*;
import java.util.*;

class Main {

    public static class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, M;
    static int cnt;
    static int[] parent;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0;j < M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 번호 기록
        visited = new boolean[N][M];
        cnt = 1;
        for (int i = 0;i < N;i++) {
            for (int j = 0;j < M;j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    countIsland(i, j);
                    cnt++;
                }
            }
        }

        // 섬의 개수 
        // System.out.println(num - 1);

        // 섬 현황 출력
        // for (int i = 0;i < N;i++) {
        //     for (int j = 0;j < M;j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();



        PriorityQueue<Edge> pq = new PriorityQueue<>((x, y) -> x.w - y.w);

        for (int i = 0;i < N;i++) {
            for (int j = 0;j < M;j++) {
                // 섬인 경우 4방향으로 다리 건설
                if (arr[i][j] > 0) {
                    int curIsland = arr[i][j];
                    for (int d = 0;d < 4;d++) {
                        int nextX = i + dx[d];
                        int nextY = j + dy[d];
                        
                        int length = 0;
                        while (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && arr[nextX][nextY] != curIsland) {  // 다음 영역이 지도 안에 존재할 경우
                            length++;

                            if (arr[nextX][nextY] >= 1 && arr[nextX][nextY] != curIsland) {
                                // 다른 섬에 도착한 경우
                                if (length - 1 < 2) {
                                    break;
                                }

                                Edge edge = new Edge(curIsland, arr[nextX][nextY], length - 1);
                                pq.offer(edge);
                                break;
                            }

                            nextX += dx[d];
                            nextY += dy[d];
                        }
                    }
                }
            }
        }

        parent = new int[cnt];
        for (int i = 0;i < cnt;i++) {
            parent[i] = i;
        }

        int result = 0;
        int useEdge = 0;
        while (!pq.isEmpty() && useEdge < cnt) {
            Edge edge = pq.poll();
            if (find(edge.s) != find(edge.e)) {
                union(edge.s, edge.e);
                result += edge.w;
                useEdge++;
            }
        }

        int p = find(1);
        boolean flag = true;
        for (int i = 2;i < cnt;i++) {
            if (p != find(i)) {
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println(result);
        } else {
            System.out.println("-1");
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[a] = b;
        }
    }

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    private static void countIsland(int x, int y) {
        if (arr[x][y] == 0) {
            return;
        }

        arr[x][y] = cnt;
        for (int i = 0;i < 4;i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                if (!visited[nextX][nextY] && arr[nextX][nextY] >= 1) {
                    visited[nextX][nextY] = true;
                    countIsland(nextX, nextY);
                }
            }
        }
    }
}