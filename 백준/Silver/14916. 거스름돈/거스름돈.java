import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = -1;
        for (int five = N / 5; five >= 0; five--) {  // 5원 개수
            int tmp = N;
            tmp -= (five * 5);

            int two = tmp / 2;  // 2원 개수
            if (tmp % 2 == 0) {
                cnt = five + two;
                break;
            }
        }

        System.out.println(cnt);

        sc.close();
    }
}