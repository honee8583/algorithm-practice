import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char[] cArr = s.toCharArray();
        for (int i = 0;i < cArr.length;i++) {
            if (!stack.isEmpty() && stack.peek() == cArr[i]) {
                stack.pop();
            } else {
                stack.push(cArr[i]);
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}