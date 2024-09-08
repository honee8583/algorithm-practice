package 백준;

import java.util.Arrays;

public class P_PCCP_2 {
    public static int solution(int[] diffs, int[] times, long limit) {
        long[] arr = new long[diffs.length];

        int answer = 0;
        long time_pre = 0;
        int start = Arrays.stream(diffs).min().getAsInt();
        int end = Arrays.stream(diffs).max().getAsInt();
        while (start <= end) {
            int level = (start + end) / 2;
            long total = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (i != 0) time_pre = times[i - 1];
                long time = getTime(diffs[i], times[i], level, time_pre);
                arr[i] = time;
                time_pre = time;
                total += time;
            }

            if (total <= limit) {
                answer = level;
                end = level - 1;
            } else {
                start = level + 1;
            }

            time_pre = 0;
        }

        System.out.println(Arrays.toString(arr));

        return answer;
    }

    public static long getTime(int diff, int time_cur, int level, long time_pre) {
        long total = 0;
        if (diff > level) {
            long cnt = diff - level; // 틀리는 횟수
            total += cnt * (time_cur + time_pre);
            total += time_cur;
        } else {
            total = time_cur;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30L));         // 3
        System.out.println(solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59L));   // 2
        System.out.println(solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723L));   // 294
        System.out.println(solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L));   // 39354
    }
}
