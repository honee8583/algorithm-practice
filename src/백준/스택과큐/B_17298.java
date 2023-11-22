package 백준.스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] A = new int[N];
        int[] result = new int[N];
        String[] str = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            // 스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클경우
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            bw.write(result[i] + " ");
        }

        bw.write("\n");
        bw.flush();
    }
}
