import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr =  new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = arr[i];

            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (arr[stack.peek()] >= num) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && arr[stack.peek()] < num) {
                        int pop = stack.pop();
                        result[pop] = num;
                    }
                    stack.push(i);
                }
            }
        }

        result[N - 1] = -1;
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}