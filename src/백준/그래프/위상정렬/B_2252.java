package 백준.그래프.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 인접리스트
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        // 진입차수 배열
        int[] arr = new int[N + 1];

        boolean[] done = new boolean[N + 1];

        // 인접리스트, 진입차수배열 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            arr[b]++;
        }

        List<Integer> result = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0 && !done[i]) {
                queue.add(i);
                done[i] = true;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            // 인접리스트 방문
            for (int i : list[cur]) {
                if (!done[i] && arr[i] > 0) {
                    arr[i]--;
                    if (arr[i] == 0) {
                        queue.offer(i);
                        done[i] = true;
                    }
                }
            }

//            for (int i = 1; i < arr.length; i++) {
//                if (arr[i] == 0 && !done[i]) {
//                    queue.add(i);
//                    done[i] = true;
//                }
//            }
        }

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
