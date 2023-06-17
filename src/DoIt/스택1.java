package DoIt;

// 백준 온라인 저지 1874번
// 난이도 : 실버5
// 시간 제한 : 2초

// 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
// 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
// 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
// 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

// 입력 : 첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
// 물론 같은 정수가 두 번 나오는 일은 없다.

// 출력 : 입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다.
// 불가능한 경우 NO를 출력한다.

import java.util.Scanner;
import java.util.Stack;

public class 스택1 {

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        int num = 1;
        int i = 0;
        while(i < N) {
            int k = arr[i];
            if (stack.isEmpty()) {
                stack.push(num++);
                sb.append("+\n");
            } else if (stack.peek() == k) {
                stack.pop();
                i++;
                sb.append("-\n");
            } else if (stack.peek() < k) {
                stack.push(num++);
                sb.append("+\n");
            } else if (stack.peek() > k) {
                sb.delete(0, sb.length());
                sb.append("No");
                break;
            }
        }
        System.out.println(sb);
    }

    public static void solution2() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < A.length; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int num = 1;
        boolean result = true;
        for (int i = 0; i < A.length; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();    // 같아졌을 경우 pop
                sb.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }

        if (result) System.out.println(sb.toString());
    }

    public static void main(String[] args) {
//        solution();
        solution2();
    }
}
