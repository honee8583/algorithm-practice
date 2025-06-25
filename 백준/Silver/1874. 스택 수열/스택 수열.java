import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack();

        boolean flag = true;
        int num = 1;
        for (int i = 0; i < N; i++) {
            int target = sc.nextInt();

            if (stack.isEmpty()) {
                if (num <= N) {
                    while (num <= target) {
                        stack.push(num++);
                        sb.append("+\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                } else {
                    break;
                }
            } else {
                if (stack.peek() > target) {
                    flag = false;
                    break;
                } else {
                    while (stack.peek() < target) {
                        stack.push(num++);
                        sb.append("+\n");
                    }
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }

        if (flag) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}