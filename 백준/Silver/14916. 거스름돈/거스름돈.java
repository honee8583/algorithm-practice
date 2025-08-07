import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int A = N / 5;  // 5원 최대 개수

        int cnt = 0;
        int tmp = N;
        boolean flag = false;
        for (int i = A; i >= 0; i--) {
            tmp -= (i * 5);
            int two = tmp / 2;
            tmp %= 2;

            if (tmp == 0) {
                flag = true;
                cnt = i + two;
                break;
            }

            cnt = 0;
            tmp = N;
        }

        if (flag) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }

        sc.close();
    }
}