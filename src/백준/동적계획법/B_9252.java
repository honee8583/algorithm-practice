package 백준.동적계획법;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_9252 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        int[][] arr = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        // 역순으로 이동하면서 문자가 같을 경우 정답에 추가
        // 왼쪽 대각선으로 이동
        // 문자가 다를경우 왼쪽, 위쪽중 큰 값으로 이동
        int i = A.length();
        int j = B.length();
        List<Character> answer = new ArrayList<>();
        while (i >= 1 && j >= 1) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                answer.add(A.charAt(i - 1));
                i = i - 1;
                j = j - 1;
            } else {
                if (arr[i - 1][j] > arr[i][j - 1]) {
                    i = i - 1;
                } else {
                    j = j - 1;
                }
            }
        }

        // 정답리스트의 사이즈를 출력해도 되지만 dp 배열의 맨 끝의 값을 출력해도 된다.
        System.out.println(arr[A.length()][B.length()]);

        for (int k = answer.size() - 1; k >= 0; k--) {
            System.out.print(answer.get(k));
        }
    }
}
