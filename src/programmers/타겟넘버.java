package programmers;

public class 타겟넘버 {

    static int count = 0;

    public static void solution(int[] numbers, int target) {
        DFS(numbers, 1, numbers[0], target);
        DFS(numbers, 1, -numbers[0], target);

        System.out.println(count);
    }

    public static void DFS(int[] arr, int p, int total, int target) {
        // 종료조건
        if (p >= arr.length) {
            if (total == target) {
                count++;
            }
            return;
        }

        if (p + 1 <= arr.length) {
            DFS(arr, p + 1,total + arr[p], target);
            DFS(arr, p + 1,total - arr[p], target);
        }
    }

    public static void main(String[] args) {
        solution(new int[]{1,1,1,1,1}, 3);  // 5
        solution(new int[]{4,1,2,1}, 4);    // 2
    }
}
