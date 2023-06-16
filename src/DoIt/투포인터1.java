package DoIt;

// 백준 온라인 저지 2018번
// 난이도 : 실버5
// 시간 제한 : 5초

// 어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
// 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다.
// 이때, 사용하는 자연수는 N이하여야 한다.
// 예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
// N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

// 입력 : 첫 줄에 정수 N이 주어진다.

// 출력 : 입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오

import java.util.Scanner;

public class 투포인터1 {

    public static void solution(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        // N까지의 배열 생성
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int i = 0;
        int j = i + 1;
        int count = 1;
        long sum = arr[i] + arr[j];
        while (i < j) {
            if (sum < N) {
                sum += arr[++j];
            } else if (sum > N) {
                sum -= arr[i++];
            } else {
                count++;
                sum -= arr[i++];
            }
        }

        System.out.println(count);
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int i = 1;
        int j = i + 1;
        int count = 1;
        long sum = i + j;
        while (i < j) {
            if (sum < N) {
                sum += ++j;
            } else if (sum > N) {
                sum -= i++;
            } else {
                count++;
                sum -= i++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        solution2();
    }
}
