package DoIt;

// 백준 온라인 저지 11286번
// 난이도 : 실버1
// 시간 제한 : 1초

// 절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.
// 1. 배열에 정수 x (x ≠ 0)를 넣는다.
// 2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
// 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
// 프로그램은 처음에 비어있는 배열에서 시작하게 된다.

// 입력: 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
// 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
// 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고
// 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -2^31보다 크고, 2^31보다 작다.

// 출력: 입력에서 0이 주어진 회수만큼 답을 출력한다.
// 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 스택_큐3 {

    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a) == Math.abs(b) ? a - b: Math.abs(a) - Math.abs(b));
        for (int i = 0; i < N; i++) {
            int k = A[i];

            if (k != 0) {
                pq.offer(k);
            } else {
                if (!pq.isEmpty()) {
                    // print
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    public static void solution2() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 우선순위 큐 정렬방법 새롭게 정의
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            // 절대값이 같은 경우 작은 값 먼저
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            // 절대값이 작은 데이터 먼저
            return first_abs - second_abs;
        }));

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(bf.readLine());
            if (request == 0) { // 들어온 데이터가 0일경우
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {// 들어온 데이터가 0이 아닐 경우
                pq.offer(request);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
