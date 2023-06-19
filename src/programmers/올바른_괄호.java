package programmers;

import java.util.Stack;

public class 올바른_괄호 {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    // split()메소드를 이용해서 푼경우 효용성부분에서 실패함
    public static boolean solution2(String s) {
        Stack<String> stack = new Stack<>();
        for(String S: s.split("")) {
            if (S.equals("(")) {
                stack.push(S);
            } else if (!stack.isEmpty()){   // 스택이 비어있지 않고 ")"가 들어온경우
                stack.pop();
            } else {    // 스택이 비어있고 ")"가 들어온경우 이미 틀린 문제임.
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("1: " + solution("()()"));
        System.out.println("2: " + solution("(())()"));
        System.out.println("3: " + solution(")()("));
        System.out.println("4: " + solution("(()("));

        System.out.println();

        System.out.println("1: " + solution2("()()"));
        System.out.println("2: " + solution2("(())()"));
        System.out.println("3: " + solution2(")()("));
        System.out.println("4: " + solution2("(()("));
    }
}
