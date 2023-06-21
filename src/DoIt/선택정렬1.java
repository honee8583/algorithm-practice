package DoIt;

// 백준 온라인 저지 1427번 - 소트인사이드
// 난이도 : 실버5
// 시간 제한 : 2초

//배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

// 입력: 첫째 줄에 정렬하려고 하는 수 N이 주어진다.
// N은 1,000,000,000보다 작거나 같은 자연수이다.
// 출력: 첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

import java.util.Scanner;

public class 선택정렬1 {

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int[] arr = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            arr[i] = S.charAt(i) - '0';
        }

        // 내림차순
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }

            if (arr[i] < arr[maxIndex]) {
                int tmp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = tmp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        solution();
    }
}
