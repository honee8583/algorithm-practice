import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        final int MAX = 100;
        
        if (progresses.length == 1) {
            return new int[]{1};
        }
        
        int[] days = new int[progresses.length];
        for (int i = 0;i < progresses.length;i++) {
            int left = MAX - progresses[i];
            // days[i] = left / speeds[i] + 1;
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        System.out.println(Arrays.toString(days));
        
        int cnt = 1;
        int max = days[0];
        // List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        for (int i = 1;i < days.length;i++) {
            if (days[i] > max) {
                answer.add(cnt);
                cnt = 1;
                max = days[i];
            } else {
                cnt++;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}