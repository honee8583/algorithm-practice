package 백준.배열과리스트;

import java.util.Scanner;

public class B_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String S = sc.next();

        int answer = 0;
        for (String num : S.split("")) {
            answer += Integer.parseInt(num);
        }

        System.out.print(answer);
    }
}
