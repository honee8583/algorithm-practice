package programmers;

import java.util.PriorityQueue;

public class 더맵게 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add((long) i);
        }

        int cnt = 0;
        while (true) {
            // 우선순의 큐에 1개의 원소만 존재하고 K를 넘지 않을 경우
            // 모든 음식의 스코빌 지수를 K이상으로 만들 수 없음
            if (pq.size() == 1 && pq.peek() < K) {
                cnt = -1;
                break;
            }

            // 모든 음식의 스코빌 지수가 K이상일 경우 break
            if (!pq.isEmpty() && pq.peek() >= K) {
                break;
            }

            // 새로운 음식을 섞고 우선순위 큐에 추가
            if (pq.size() >= 2) {
                long a = pq.poll();
                long b = pq.poll();

                long newFood = a + b * 2;

                pq.add(newFood);
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int answer = solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println(answer);
    }
}
