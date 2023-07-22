package zerobase.이진탐색;

// 정수형 배열 nums와 정수 m이 주어졌다.
// nums에는 양의 정수 값들이 들어있고, m은 배열을 부분배열로 분리할 수 있는 수이다.
// nums 배열을 m 개의 부분 배열로 분리할 때,
// 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 분리했을 때의 값을 출력하시오.

import java.util.Arrays;

public class Practice5 {
    public static int solution(int[] nums, int m) {
        int min = Integer.MAX_VALUE;

        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 1;
            int sum = 0;
            for (int n : nums) {
                if (sum + n > mid) {
                    cnt ++;
                    sum = 0;
                }
                sum += n;
            }

            if (cnt == m) {
                if (min > mid) {
                    min = mid;
                }
                right = mid - 1;
            } else if (cnt > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2));  // 18

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2));  // 9

        nums = new int[]{1, 4, 4};
        System.out.println(solution(nums, 3));  // 4
    }
}
