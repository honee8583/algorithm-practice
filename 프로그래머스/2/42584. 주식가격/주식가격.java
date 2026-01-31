import java.util.*;
import java.io.*;

class Node {
    int idx;
    int val;
    Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Node> stack = new Stack<>();
        for (int i = 0;i < prices.length;i++) {
            if (!stack.isEmpty()) { // 가격이 떨어진경우
                while (!stack.isEmpty() && stack.peek().val > prices[i]) {
                    Node popedNode = stack.pop();
                    answer[popedNode.idx] = i - popedNode.idx; // 인덱스 차이만큼 값 입력    
                }
                stack.push(new Node(i, prices[i]));
            } else {  // 가격이 떨어지지 않은 경우
                stack.push(new Node(i, prices[i]));
            }
            // System.out.println(stack.peek().idx + ": " + stack.peek().val);
        }
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            answer[node.idx] = prices.length - 1 - node.idx;
        }
        
        return answer;
    }
}