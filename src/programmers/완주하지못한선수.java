package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 1) - 1);
        }

        String result = "";
        for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() > 0) {
                result = entrySet.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
}
