package DoIt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {

    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!list.get(a).contains(b)) {
                list.get(a).add(b);
            }

            if (!list.get(b).contains(a)) {
                list.get(b).add(a);
            }
        }

        // init
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 1; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[1] = true;

        int count = 0;
        while (true) {
            if (stack.isEmpty()) {
                boolean flag = false;   // 종료 여부
                for (int j = 1; j < visited.length; j++) {  // 방문배열의 처음부터 돌아 방문하지 않은 곳을 방문한다.
                    if (!visited[j]) {
                        stack.push(j);
                        visited[j] = true;
                        flag = true;   // 더 진행 가능
                    }
                }

                count++;

                if (!flag) {
                    break;
                }
            }

            int p = stack.pop();
            List<Integer> arrList = list.get(p);    // 2, 1
            for (int j = 0; j < arrList.size(); j++) {  // 꺼낸 숫자의 인접리스트의 요소를 모두 스택에 삽입(방문한적이 없을 경우)
                int next = arrList.get(j);
                if (!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                }
            }
        }

        System.out.println(count);
    }

    public static void solution2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];             // 방문배열
        ArrayList<Integer>[] list = new ArrayList[N + 1];   // 인접리스트

        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        int count = 0;
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(list, visited, i);
            }
        }

        System.out.println(count);
    }

    public static void DFS(ArrayList<Integer>[] list, boolean[] visited, int v) {
        if (visited[v]) {   // 현재 노드가 방문노드일경우
            return;
        }

        visited[v] = true;

        for (int i : list[v]) {
            if (!visited[i]) {
                DFS(list, visited, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }
}
