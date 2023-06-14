package DoIt;

//백준 온라인 저지 111720번
//난이도 : 브론즈2
//시간 제한 : 1초

//N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
//입력 : 1번째 줄에 숫자의 개수 N(1 ≤ N ≤ 100), 2번째 줄에 숫자 N개가 공백없이 주어진다.

import java.util.Scanner;

public class 배열1 {

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        int sum = 0;
        char[] cArr = str.toCharArray();
        for (char c : cArr) {
            // sum += c - '0';
            sum += c - 48;   // 48 또는 '0'을 빼주면 숫자로 변환된다.
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
