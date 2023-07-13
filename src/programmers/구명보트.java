package programmers;

import java.util.Arrays;

public class 구명보트 {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int count = 1;
        int start = 0;      // 작은수
        int end = people.length - 1;    // 큰수
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
                count++;
            } else {
                count++;
                end--;
            }
        }

        System.out.println(count - 1);

        return count;
    }

    public static void main(String[] args) {
        solution(new int[]{70, 50, 80, 50}, 100);
        solution(new int[]{70, 80, 50}, 100);
    }
}
