package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int i = 0;
        int sum = truck_weights[i];    // 총 무게
        int time = 1;   // 경과시간
        Queue<Integer> queue = new LinkedList<>();
        queue.add(truck_weights[i++]);
        while (sum > 0) {
            if (i < truck_weights.length) {
                if (queue.size() + 1 <= bridge_length) { // 개수O
                    if (sum + truck_weights[i] <= weight) { // 개수O, 무게 O
                        queue.add(truck_weights[i]);
                        sum += truck_weights[i++];
                    } else {    // 개수O, 무게X
                        queue.add(0);
                    }
                } else {    // 다리위 트럭 개수초과
                    sum -= queue.poll();
                    if (sum + truck_weights[i] <= weight) {
                        queue.add(truck_weights[i]);
                        sum += truck_weights[i++];
                    } else {
                        queue.add(0);
                    }
                }
            } else {
                if (queue.size() >= bridge_length) {
                    sum -= queue.poll();
                }
                queue.add(0);
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6})); // 8
        System.out.println(solution(100, 100, new int[]{10}));  // 101
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));   // 110
    }
}
