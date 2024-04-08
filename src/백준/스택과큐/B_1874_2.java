package 백준.스택과큐;

import java.util.Scanner;
import java.util.Stack;

public class B_1874_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        int num = 1;
        boolean available = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();

            while (num <= n) {
                stack.push(num++);
                sb.append("+\n");
            }

            if (stack.peek() > n) {
                available = false;
                System.out.println("NO");
                break;
            }

            if (!stack.isEmpty()) {
                stack.pop();
                sb.append("-\n");
            }
        }

        if (available) {
            System.out.println(sb);
        }
    }
}
