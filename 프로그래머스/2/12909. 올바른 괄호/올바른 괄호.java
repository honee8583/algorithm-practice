import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        final char OPEN = '(';
        final char CLOSE = ')';
        
        char[] cArr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < cArr.length;i++) {
            if (cArr[i] == OPEN) {
                stack.push(1);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();    
                } else {
                    answer = false;
                    break;
                }
                
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}