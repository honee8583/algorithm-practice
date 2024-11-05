package 백준.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class B_2750 {
    public static void main(String[] args) {
        // N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
        // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
        // 둘째 줄부터 N개의 줄에는 수가 주어진다.
        // 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 버블정렬 - 오름차순
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i + 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
