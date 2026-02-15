import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wMap = new HashMap<>();  // 내가 원하는 목록/수량
        for (int i = 0;i < want.length;i++) {
            wMap.put(want[i], number[i]);
        }
        
        int start = 0;
        int end = start + 9;
        Map<String, Integer> dMap = new HashMap<>();  // 할인 목록/수량
        for (int i = start;i <= end;i++) {
            dMap.put(discount[i], dMap.getOrDefault(discount[i], 0) + 1);
        }
        
        int answer = 0;
        final int total = discount.length;
        while (end < total) {
            boolean flag = true;
            for (String key : wMap.keySet()) {
                if (dMap.containsKey(key)) {
                    if (wMap.get(key) > dMap.get(key)) {  // 내가 원하는 물품/수량이 할인 물품/수량과 같지 않다면
                        flag = false;
                        break;
                    }    
                } else {
                    flag = false;
                    break;
                }
            }
            
            // 내가 원하는 물품/수량이 할인 물품/수량과 모두 같을 경우
            if (flag) {
                answer++;
            }
            
            // 다음 윈도우 이동 + 할인 목록/수량 수정
            dMap.put(discount[start], dMap.getOrDefault(discount[start], 1) - 1);
            start++;
            
            if (end + 1 < total) {
                dMap.put(discount[end + 1], dMap.getOrDefault(discount[end + 1], 0) + 1);
            } else {
                break;
            }
            end++;
        }
        
        return answer;
    }
}