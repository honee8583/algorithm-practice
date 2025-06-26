import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        for (int i = N;i > 0;i--) {
            deque.addFirst(i);
        }

        while (deque.size() > 1) {
            deque.pollFirst();

            if (deque.size() > 1) {
                deque.addLast(deque.pollFirst());
            }
        }

        System.out.println(deque.pollFirst());
        
    }
}