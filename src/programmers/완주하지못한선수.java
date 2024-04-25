package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }

        String result = "";
        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                result = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
    }
}
