package zerobase.이진탐색;

// 2차원행렬에서 이진탐색으로 데이터 찾기
// row x col 행렬데이터가 주어졌을 때, target을 이진탐색으로 찾는 프로그램을 작성하세요.
// 각 행의 데이터는 오름차순으로 정렬 상태

public class Practice3 {
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int left = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int M = matrix[mid / cols][mid % cols];

            if (target == M) {
                return true;
            } else if (target < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,7,8}, {10,11,15,20}, {21,30,35,60}};
        System.out.println(solution(matrix, 3));    // true
        System.out.println(solution(matrix, 13));   // false
        System.out.println(solution(matrix, 35));   // true
    }
}
