package zerobase.이진탐색;

// 정수형 배열 weights와 정수 days가 주어졌다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days는 운송 납기일이다.
// 상품들은 weights에 적혀있는 순서대로 실어서 운송해야 된다.
// days내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하시오.

import java.util.Arrays;

public class Practice4 {
    public static int solution(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int idx = 0;
            int cnt = 1;
            int sum = 0;
            while (idx <= weights.length - 1) {
                if (sum + weights[idx] <= mid) {
                    sum += weights[idx++];
                } else {
                    cnt++;
                    sum = 0;
                }
            }

            if (cnt == days) {
                return mid;
            } else if (cnt < days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
