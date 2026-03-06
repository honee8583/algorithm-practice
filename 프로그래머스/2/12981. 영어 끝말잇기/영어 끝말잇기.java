import java.util.*;
import java.util.stream.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int cur = 1;
        int turn = 1;
        char nextChar = words[0].toCharArray()[words[0].length() - 1];
        Set<String> past = new HashSet<>();
        for (int i = 0;i < words.length;i++) {
            String word = words[i];
            
            if (i > 0) {
                if (nextChar != word.toCharArray()[0]) {
                    return new int[]{cur, turn};
                }
                nextChar = word.toCharArray()[words[i].length() - 1];
            }
            
            if (past.contains(word)) {
                return new int[]{cur, turn};
            } else {
                past.add(word);
            }
            
            if (cur % n == 0) {
                // 한 턴의 마지막 사람인 경우
                turn++;
                cur = 1;
            } else {
                cur++;
            }
        }
        
        return new int[]{0, 0};
    }
}