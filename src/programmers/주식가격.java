package programmers;

import java.util.Arrays;

public class 주식가격 {

    public static int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                } else {
                    ++count;
                    break;
                }
            }

            result[i] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 3, 2, 3});  // 4, 3, 1, 1, 0
        Arrays.stream(result).forEach(System.out::print);
    }
}
