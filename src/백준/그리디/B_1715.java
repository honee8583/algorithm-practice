package 백준.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(sc.nextLong());
        }

        int sum = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();

            sum += (first + second);
            pq.offer(first + second);
        }

        System.out.println(sum);
    }
}
