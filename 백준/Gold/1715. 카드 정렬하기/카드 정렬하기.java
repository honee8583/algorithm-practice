import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(sc.nextInt());
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            int tmp = 0;

            int a = pq.poll();
            int b = 0;
            
            if (!pq.isEmpty()) {
                b = pq.poll();
                tmp = a + b;
                pq.add(tmp);
                sum += tmp;
            }
        }

        System.out.println(sum);

        sc.close();
    }
}