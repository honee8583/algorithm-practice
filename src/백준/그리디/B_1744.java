package 백준.그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class B_1744 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int zero = 0;
        int one = 0;
        PriorityQueue<Long> apq = new PriorityQueue<>((x, y) -> (int) (y - x));    // 양수 : 내림차순
        PriorityQueue<Long> bpq = new PriorityQueue<>();    // 음수 : 오름차순
        for (int i = 0; i < N; i++) {
            long cur = sc.nextLong();
            if (cur > 1) {
                apq.add(cur);
            } else if (cur < 0){
                bpq.add(cur);
            } else if (cur == 1){
                one++;
            } else {
                zero++;
            }
        }

        long sum = 0;
        while (apq.size() > 1) {
            sum += (apq.poll() * apq.poll());
        }
        if (!apq.isEmpty()) {
            sum += apq.poll();
        }

        while (bpq.size() > 1) {
            sum += (bpq.poll() * bpq.poll());
        }

        if (!bpq.isEmpty()) {
            if (zero == 0) {
                sum += bpq.poll();
            }
        }

        sum += one;

        System.out.println(sum);
    }
}
