package 백준.스택과큐;

import java.util.Scanner;
import java.util.Stack;

public class B_1874_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            int target = arr[i];

            if (target >= num) {
                // 최대한 push
                while (target >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                // 목표값에 도달하면 추출
                stack.pop();
                sb.append("-\n");
            } else {
                 int n = stack.pop();

                 if (n > target) {
                     System.out.println("NO");
                     flag = false;
                     break;
                 } else {
                     sb.append("-\n");
                 }
            }
        }

        if (flag) {
            System.out.println(sb);
        }
    }
}
