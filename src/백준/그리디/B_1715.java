package 백준.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            pq.offer(num);
        }

        int sum = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            sum += (a + b);
            pq.offer(a + b);
        }

        System.out.println(sum);
    }
}
