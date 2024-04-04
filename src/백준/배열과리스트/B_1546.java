package 백준.배열과리스트;

import java.util.Arrays;
import java.util.Scanner;

public class B_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] grades = new double[N];
        for (int i = 0; i < N; i++) {
            grades[i] = sc.nextDouble();
        }

        double max = Arrays.stream(grades).max().getAsDouble();
        double avg = Arrays.stream(grades).average().getAsDouble();
        avg = avg / max * 100;
        System.out.println(avg);
    }
}
