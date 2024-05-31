package 백준.동적계획법;

import java.util.Scanner;

// 동적계획법 알고리즘이지만
// 상근이가 먼저 돌을 가져가게 되므로
// 총 돌의 개수가 홀수 일경우 마지막 돌은 상근이가 가져가게 되고,
// 총 돌의 개수가 짝수 일경우 마지막 돌은 창영이가 가져가게 된다.
public class B_9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
