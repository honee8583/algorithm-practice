package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_1707 {
    static boolean result;
    static int V;
    static int E;

    static List<List<Integer>> list;
    static boolean[] visited;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int K = Integer.parseInt(st.nextToken());   // 테스트 케이스

        for (int i = 0; i < K; i++) {
            result = true;

            st = new StringTokenizer(bf.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            // 인접리스트 구성
            list = new ArrayList<>();
            for (int j = 0; j <= V; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            check = new int[V + 1];
            System.out.println(Arrays.toString(check));

            visited = new boolean[V + 1];
            for (int j = 1; j <= V; j++) {
                if (result) {
                    DFS(j);
                } else {
                    break;
                }
            }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int cur) {
        visited[cur] = true;

        for (int nearNode : list.get(cur)) {
            if (!visited[nearNode]) {
                check[nearNode] = (check[cur] + 1) % 2;
                DFS(nearNode);
            } else if (check[cur] == check[nearNode]){
                result = false;
            }
        }
    }

//    public static void BFS(int start) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(start);
//        visited[start] = true;
//        color[start] = "R";
//
//        while (!queue.isEmpty()) {
//            int cur = queue.poll();
//
//            for (int nearNode : list.get(cur)) {
//                // 아직 방문하지 않았고 색값이 들어오지 않았을 경우
//                if (!visited[nearNode] && color[nearNode] == null) {
//                    if (color[cur].equals("R")) {
//                        color[nearNode] = "B";
//                    } else if (color[cur].equals("B")) {
//                        color[nearNode] = "R";
//                    }
//                    visited[nearNode] = true;
//                    queue.add(nearNode);
//                } else if (visited[nearNode] && color[nearNode].equals(color[cur])) {
//                    result = false;
//                    break;
//                }
//            }
//
//            if (!result) {
//                break;
//            }
//        }
//    }
}
