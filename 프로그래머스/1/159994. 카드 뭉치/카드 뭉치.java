import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Queue<String> q1 = new ArrayDeque<>();
        for (String c1 : cards1) {
            q1.add(c1);
        }
        
        Queue<String> q2 = new ArrayDeque<>();
        for (String c2 : cards2) {
            q2.add(c2);
        }
        
        for (int i = 0;i < goal.length;i++) {
            String g = goal[i];
            
            if (!q1.isEmpty() && !q1.peek().equals(g) && 
                !q2.isEmpty() && !q2.peek().equals(g)) { // q1, q2 둘다 없을 경우
                return "No";
            } else if (!q1.isEmpty() && q1.peek().equals(g)) {
                String q = q1.poll();
                System.out.println("q1: " + q1);
            } else if (!q2.isEmpty() && q2.peek().equals(g)) {
                String q = q2.poll();
                System.out.println("q2: " + q2);
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}