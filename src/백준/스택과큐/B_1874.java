package 백준.스택과큐;

import java.util.Scanner;
import java.util.Stack;

public class B_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        stack.push(num++);
        sb.append("+\n");
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            if (!stack.isEmpty() && stack.peek() > target) {
                flag = false;
                break;
            }

            while (stack.isEmpty() || stack.peek() < target) {
                stack.push(num++);
                sb.append("+\n");
            }

            stack.pop();
            sb.append("-\n");
        }

        if (!flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }
    }
}
