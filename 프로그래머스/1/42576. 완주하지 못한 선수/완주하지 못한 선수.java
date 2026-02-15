import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> pMap = new HashMap<>();
        for (String p : participant) {
            // if (!pMap.containsKey(p)) {
            //     p.put(p, 1);
            // } else {
            //     pMap.put(p, pMap.get(p) + 1);
            // }
            pMap.put(p, pMap.getOrDefault(p, 0) + 1);
        }
        
        for (String c : completion) {
            if (pMap.containsKey(c)) {
                pMap.put(c, pMap.getOrDefault(c, 1) - 1);
            }
        }
        
        for (Map.Entry<String, Integer> entry : pMap.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return "";
    }
}