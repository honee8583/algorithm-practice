package DoIt;

// 백준 온라인 저지 1546번
// 난이도 : 브론즈1
// 시간제한 : 2초

// 세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
//  일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
//  그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
// 예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
// 세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 시험 본 과목의 개수 N이 주어진다.
// 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다.
// 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.

// 출력 : 첫째 줄에 새로운 평균을 출력한다.
// 실제 정답과 출력값의 절대오차 또는 상대오차가 10^2 이하이면 정답이다.

import java.util.Arrays;

public class 배열2 {

    public static double solution(int N, int[] arr) {
        double result = 0;

        // 최대점수
        int Max = Arrays.stream(arr).max().getAsInt();
        for(int i : arr) {
            result += (double) (i * 100) / Max;
        }

        return result / N;
    }

    public static double solution2(int N, int[] arr) {
        long max = Arrays.stream(arr).max().getAsInt();
        long sum = Arrays.stream(arr).sum();

        return sum * 100.0 / max / N;   // .0으로 계산할시 자동으로 double형으로 형변환 된다
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[]{40, 80, 60}));
        System.out.println(solution(3, new int[]{10, 20, 30}));
        System.out.println(solution(4, new int[]{1, 100, 100, 100}));
        System.out.println(solution(5, new int[]{1, 2, 4, 8, 16}));
        System.out.println(solution(2, new int[]{3, 10}));
        System.out.println(solution(4, new int[]{10, 20, 0, 100}));
        System.out.println(solution(2, new int[]{1, 50}));
        System.out.println(solution(9, new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}));
        System.out.println();

        // Solution2
        System.out.println(solution2(3, new int[]{40, 80, 60}));
        System.out.println(solution2(3, new int[]{10, 20, 30}));
        System.out.println(solution2(4, new int[]{1, 100, 100, 100}));
        System.out.println(solution2(5, new int[]{1, 2, 4, 8, 16}));
        System.out.println(solution2(2, new int[]{3, 10}));
        System.out.println(solution2(4, new int[]{10, 20, 0, 100}));
        System.out.println(solution2(2, new int[]{1, 50}));
        System.out.println(solution2(9, new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}));
    }
}
