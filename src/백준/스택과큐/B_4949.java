package 백준.스택과큐;

import java.io.*;
import java.util.*;

public class B_4949 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = "";
        while (true) {
            line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            sb.append(checkStack(line, stack)).append("\n");
        }

        System.out.println(sb);
    }

    private static String checkStack(String line, Stack<Character> stack) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '(' || c == '[') {
                stack.add(c);
            } else {
                if (c == ')') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() != '(') {
                            return "no";
                        } else if (stack.peek() == '(') {
                            stack.pop();
                        }
                    } else {
                        return "no";
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() != '[') {
                            return "no";
                        } else if (stack.peek() == '[') {
                            stack.pop();
                        }
                    } else {
                        return "no";
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
