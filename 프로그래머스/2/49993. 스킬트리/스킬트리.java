import java.util.*;
import java.io.*;

class Solution {
    List<Character> list;
    Queue<Character> q;
    
    public int solution(String skill, String[] skillTrees) {
        int answer = -1;
        
        list = new ArrayList<>();
        for (char c : skill.toCharArray()) {
            list.add(c);
        }
        
        int cnt = 0;
        q = initQueue(skill);
        for (String str : skillTrees) {
            boolean ok = isOk(str);
            if (ok) {
                cnt++;
            }
            q = initQueue(skill);
        }
        
        return cnt;
    }
    
    private Queue<Character> initQueue(String skill) {
        Queue<Character> q = new ArrayDeque<>();
        for (char c : skill.toCharArray()) {
            q.add(c);
        }
        return q;
    }
    
    private boolean isOk(String skill) {   
        for (char c : skill.toCharArray()) {
            if (list.contains(c)) {
                char a = q.poll();
                if (c != a) {
                    return false;
                }
            }
        }
        
        return true;
    }
}