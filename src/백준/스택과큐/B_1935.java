package 백준.스택과큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class B_1935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] sArr = br.readLine().split("");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(String.valueOf((char) (65 + i)), Integer.parseInt(br.readLine()));
        }

        Stack<String> initStack = new Stack<>();
        for (String s : sArr) {
            if (map.get(s) == null) {
                initStack.push(s);
            } else {
                initStack.push(String.valueOf(map.get(s)));
            }
        }

        Stack<String> calcStack = new Stack<>();
        int cnt = 0;
        while (initStack.size() != 1) {
            while (cnt != 2) {
                String s = initStack.pop();
                calcStack.push(s);
                if (!s.equals("*") && !s.equals("+") && !s.equals("/") && !s.equals("-")) {
                    cnt++;
                } else {
                    cnt = 0;
                }
            }
            cnt = 0;

            if (calcStack.size() >= 3) {
                double s1 = Double.parseDouble(calcStack.pop());
                double s2 = Double.parseDouble(calcStack.pop());
                String calc = calcStack.pop();

                switch (calc) {
                    case "*":
                        initStack.push(String.valueOf(s1 * s2));
                        break;
                    case "+":
                        initStack.push(String.valueOf(s1 + s2));
                        break;
                    case "-":
                        initStack.push(String.valueOf(s1 - s2));
                        break;
                    case "/":
                        initStack.push(String.valueOf(s1 / s2));
                        break;

                }
            }

            while (!calcStack.isEmpty()) {
                initStack.push(calcStack.pop());
            }
        }

        bw.write(String.format("%.2f", Double.parseDouble(initStack.pop())) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
