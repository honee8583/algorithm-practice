package DoIt;

// 백준 온라인 저지 1920번
// 난이도 : 실버4
// 시간 제한 : 2초

// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
// 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다.
// 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
// 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
// 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
// 모든 정수의 범위는 -2^31보다 크거나 같고 2^31보다 작다.

// 출력 : M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 4, 1, 5, 2, 3
// 1, 2, 3, 4, 5
// target = 7
// m = 2
// start= = 3, end = 4
// m = 3
// start = 4, end = 4


public class 이진탐색 {

    public static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 배열 구성
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 이진탐색은 정렬이돼있어야 한다

        // 확인할 숫자 구성
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] checkArr = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        bf.close();

        for (int i = 0; i < M; i++) {
            binarySearch(arr, 0, arr.length - 1, checkArr[i]);
        }
    }

    public static void binarySearch(int[] arr, int start, int end, int target) {
        int m = (start + end) / 2;

        // 배열에 타겟이 없는 경우
        if (start == end && target != arr[m]) {
            System.out.print(0 + " ");
            return;
        }

        if (arr[m] == target) {
            System.out.print(1 + " ");
        } else if (target < arr[m]) {
            binarySearch(arr, start, m - 1, target);
        } else if (target > arr[m]) {
            binarySearch(arr, m + 1, end, target);
        }
    }

    public static void solution2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 배열 구성
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 이진탐색은 정렬이돼있어야 한다

        // 확인할 숫자 구성
        st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());

        int[] checkArr = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        bf.close();

        for (int k = 0; k < checkArr.length; k++) {
            int i = 0;
            int j = arr.length - 1;
            int target = checkArr[k];
            boolean flag = false;

            while (i <= j) {
                int m = (i + j) / 2;

                if (arr[m] == target) {
                    flag = true;
                    break;
                } else if (arr[m] < target) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }

            if (flag) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }


    public static void main(String[] args) throws IOException {
//        solution();     // 1, 1, 0, 0, 1
        solution2();    // 1, 1, 0, 0, 1
    }
}
