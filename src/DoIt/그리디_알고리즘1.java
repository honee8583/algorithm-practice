package DoIt;

import java.util.Scanner;

// 백준 온라인 저지 11047
// 난이도 : 실버 4
// 시간 제한 : 1초

//준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
//동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
// 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

// 입력: 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
// 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다.
// (1 ≤ Ai≤ 1,000,000, A1= 1, i≥ 2인 경우에Ai는 Ai-1의 배수)
// 출력: 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

public class 그리디_알고리즘1 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 동전 종류 개수
        int K = sc.nextInt();   // 목표 금액

        // 동전 배열 구성
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int coin = arr[i];
            if (coin < K) {
                count += K / coin;
                K = K % coin;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        solution();
    }
}
