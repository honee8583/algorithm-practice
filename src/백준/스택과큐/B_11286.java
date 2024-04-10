package 백준.스택과큐;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B_11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

//        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (Math.abs(o1) == Math.abs(o2)) {
//                    return o1 - o2;
//                }
//                return Math.abs(o1) - Math.abs(o2);
//            }
//        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> {
            if (Math.abs(x) == Math.abs(y)) {
                return x - y;
            }
            return Math.abs(x) - Math.abs(y);
        });

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num != 0) {
                pq.offer(num);
            } else {
                if (!pq.isEmpty()) {
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
