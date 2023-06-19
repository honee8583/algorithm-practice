package programmers;

import java.util.*;

public class 같은숫자는싫어 {

    public static int[] solution(int[] arr) {
        // 리스트를 사용하는 해결
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty()) {
                list.add(arr[i]);
            } else if (list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static int[] solution2(int[] arr) {
        // 스택을 사용하여 해결
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{1,1,3,3,0,1});
        Arrays.stream(answer).forEach(System.out::print);
    }
}
