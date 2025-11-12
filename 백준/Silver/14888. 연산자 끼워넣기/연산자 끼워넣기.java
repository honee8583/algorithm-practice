import java.io.*;
import java.util.*;

class Main {
    static int N, max, min;
    static int[] arr;
    static int[] visited;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1;i <= N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        visited = new int[4];  // 연산자 개수
        for (int i = 0;i < 4;i++) {
            visited[i] = Integer.parseInt(st.nextToken());
        }

        q = new LinkedList<>();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        DFS(arr[1], 1);

        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int result, int depth) {
        if (depth == N) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0;i < 4;i++) {
            if (visited[i] > 0) {
                visited[i]--;
                DFS(calc(result, arr[depth + 1], i), depth + 1);
                visited[i]++;
            }
        }
    }

    private static int calc(int result, int cur, int calcIdx) {
        if (calcIdx == 0) {
            result += cur;
        } else if (calcIdx == 1) {
            result -= cur;
        } else if (calcIdx == 2) {
            result *= cur;
        } else {
            if (result < 0) {
                result = Math.abs(result);
                result /= cur;
                result *= (-1);
            } else {
                result /= cur;
            }
        }
        return result;
    }

    // private static void calculate() {
    //     int idx = 1; 
    //     int result = arr[idx];
    //     while(!q.isEmpty()) {
    //         idx++;
    //         int cur = arr[idx];
    //         int calcIdx = q.poll();

    //         if (calcIdx == 0) {
    //             result += cur;
    //         } else if (calcIdx == 1) {
    //             result -= cur;
    //         } else if (calcIdx == 2) {
    //             result *= cur;
    //         } else {
    //             if (result < 0) {
    //                 result = Math.abs(result);
    //                 result /= cur;
    //                 result *= (-1);
    //             } else {
    //                 result /= cur;
    //             }
    //         }
    //     }

    //     min = Math.min(min, result);
    //     max = Math.max(max, result);
    // }
}