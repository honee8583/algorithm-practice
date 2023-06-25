package programmers;

import java.util.Arrays;

public class H_index {

    public static int solution(int[] citations) {
        int result = -1;
        Arrays.sort(citations);
        for (int h = 1; h <= citations.length; h++) {
            int a = 0;  // h번 이상 사용한 논문의 수
            int b = 0;  // h번 이하 사용한 논문의 수
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= h) {
                    a++;
                } else {
                    b++;
                }
            }

            if (a >= h && b <= h) {
                result = h;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
