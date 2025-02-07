package 백준.스택과큐;

import java.io.*;
import java.util.*;

public class B_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String line = br.readLine();

            Stack<Character> stack = new Stack<>();
            char[] cArr = line.toCharArray();
            for (Character c : cArr) {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.push(')');
                        break;
                    }
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                bw.write("NO\n");
            } else {
                bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
