package programmers;

import java.util.*;

public class 프로세스 {
    public static int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>(); // 결과
        int max = Arrays.stream(priorities).max().getAsInt();
        while (!queue.isEmpty()) {
            int present = queue.poll();

            if (priorities[present] < max) {
                queue.add(present);
            } else {
                list.add(present);
                priorities[present] = 0;
                max = Arrays.stream(priorities).max().getAsInt();
            }
        }

        return list.indexOf(location) + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
    }
}
