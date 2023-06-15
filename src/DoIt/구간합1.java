package DoIt;

// 백준 온라인 저지 11659번
// 난이도 : 실버4
// 시간 제한 : 0.5초

// 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.

// 입력: 1번째 줄에 수의 개수N(1 ≤ N ≤ 100,000), 합을 구해야 하는 횟수 M(1 ≤ M ≤ 100, 000),
// 2번째 줄에 N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수이다.
// 3번째줄부터는 M개의 줄에 합을 구해야 하는 구간 i와 j가 주어진다.

// 출력 : 총 M개의 줄에 입력으로 주어진 i번째 수에서 j번째 수까지의 합을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 구간합1 {

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열 받기
        int[] a = new int[N + 1];
        int[] s = new int[a.length];
        s[0] = 0;
        for (int i = 1; i < N + 1; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
        }

        // 구간합 구하기
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(s[end] - s[start - 1]);
        }
    }

    public static void solution2() throws IOException {
        // 받는 데이터가 많을 경우 Scanner보다 BufferedReader를 사용하는 것이 좋다.(더 빠르다)
        // (여기서는 100,000 개의 데이터를 입력받음)
        BufferedReader bf = new BufferedReader((new InputStreamReader(System.in)));

        // readLine() 첫번째 줄을 읽어온다
        // 한줄에 여러개의 수가 들어오게 될경우(여기서는 100,000개) StringTokenizer 클래스를 사용한다.
        StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] s = new long[suNo + 1];  // 합배열

        stringTokenizer = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= suNo; i++) {
            s[i] = s[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bf.readLine());

            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(s[j] - s[i - 1]);
        }
    }

    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }
}
