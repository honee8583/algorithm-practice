import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zero = 0;
        int change = 0;
        while (!s.equals("1")) {
            char[] cArr = s.toCharArray();
            for (int i = 0;i < cArr.length;i++) {
                if (cArr[i] == '0') {
                    zero++;
                }
            }
            
            s = s.replaceAll("0", ""); // 0 제거
            
            s = Integer.toBinaryString(s.length());
            change++;
        }
        
        answer[0] = change;
        answer[1] = zero;
        
        return answer;
    }
}