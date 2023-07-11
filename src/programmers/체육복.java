package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        for (int i = 1; i <= n; i++) {
            if (lostList.contains(i) && reserveList.contains(i)) {
                reserveList.remove(Integer.valueOf(i));
                lostList.remove(Integer.valueOf(i));
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!lostList.contains(i)) {
                count++;
            } else {
                if (reserveList.contains(i - 1)) {
                    count++;
                    reserveList.remove(Integer.valueOf(i - 1));
                } else if (reserveList.contains(i + 1)) {
                    count++;
                    reserveList.remove(Integer.valueOf(i + 1));
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));   // 5
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));         // 4
        System.out.println(solution(3, new int[]{3}, new int[]{1}));            // 2
    }
}
