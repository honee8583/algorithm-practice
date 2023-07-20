package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 크레인_인형뽑기_게임 {
    public static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> stackList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            stackList.add(new Stack<>());
        }

        for (int i = board.length - 1; i >=  0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                int num = board[i][j];
                if (num != 0) {
                    stackList.get(j).add(num);
                }
            }
        }

        Stack<Integer> result = new Stack<>();

        int cnt = 0;
        for (int i = 0; i < moves.length; i++) {
            Stack<Integer> stack = stackList.get(moves[i] - 1);

            if (!stack.isEmpty()) {
                int next = stack.pop();

                if (!result.isEmpty()) {
                    if (result.peek() == next) {
                        result.pop();
                        cnt+=2;
                    } else {
                        result.add(next);
                    }
                } else {
                    result.add(next);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int result = solution(
                new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4});

        System.out.println("cnt: " + result);
    }
}
