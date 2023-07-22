package zerobase.이진탐색;

// 원형 정렬 상태 배열에서의 이진 탐색
// nums배열에 원형 상태로 데이터가 정렬되어 있을 때,
// 이진탐색으로 데이터를 찾는 프로그램을 작성하세요.

// O(logn)유지
// 배열을 재정렬하지 않고 풀기

public class Practice2 {
    public static int solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            // 4, 5, 6, 7, 0, 1, 2
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid - 1;
                }
            } else {
                // 11, 5, 6, 7, 8, 9, 10
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,0,1,2};
        System.out.println(solution(nums, 0));
        System.out.println(solution(nums, 3));
    }
}
