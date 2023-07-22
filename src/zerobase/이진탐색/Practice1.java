package zerobase.이진탐색;

// target 값이 arr내에 있으면 해당 인덱스 반환
// 없으면 있을 경우의 위치에 -1을 곱하고 1을 뺀값을 반환

public class Practice1 {
    public static int solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int m = arr[mid];

            if (m == target) {
                return mid;
            } else if (m < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -left - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,30,40,50,60};
        System.out.println(solution(arr, 30));  // 5
        System.out.println(solution(arr, 3));   // -3
        System.out.println(solution(arr, 11));  // -5
        System.out.println(solution(arr, 35));  // -7
    }
}
