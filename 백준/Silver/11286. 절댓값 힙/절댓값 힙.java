import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    int absA = Math.abs(o1);
                    int absB = Math.abs(o2);

                    if (absA < absB) {
                        return -1;
                    } else if (absA == absB) {
                        if (o1 < o2) {
                            return -1;
                        } else if (o1 > o2) {
                            return 1;
                        } else {
                            return 0;
                        }
                    } else {
                        return 1;
                    }
                };
            }
        );

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x != 0) {
                pq.add(x);
            } else if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
        }

    }
}