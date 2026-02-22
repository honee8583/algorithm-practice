import java.util.*;
import java.io.*;
import java.util.stream.*;

class Solution {
    
    // 요리 길이 별 <코스 요리 별 주문 횟수>
    private Map<Integer, Map<String, Integer>> orderMap = new HashMap<>(); 
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        // 모든 메뉴 조합 기록
        for (String o : orders) {
            combination(0, o.toCharArray(), "");
        }
        
        // 출력
        // for (Map<String, Integer> order : orderMap.values()) {
        //     for (Map.Entry<String, Integer> entry : order.entrySet()) {
        //         System.out.println(entry.getKey() + ": " + entry.getValue());
        //     }
        // }
        
        List<String> orderList = new ArrayList<>();
        for (int c : course) {
            int maxOrderCnt = 2;  // 코스별 인기가 가장 많은 주문 개수
            if (orderMap.containsKey(c)) {
                for (Map.Entry<String, Integer> entry : orderMap.get(c).entrySet()) {  // NULL
                    // 인기가 가장 많은 메뉴 추출
                    if (entry.getValue() > maxOrderCnt) {
                        maxOrderCnt = entry.getValue();
                    }
                    maxOrderCnt = Math.max(maxOrderCnt, entry.getValue());
                }
                
                 for (Map.Entry<String, Integer> om : orderMap.get(c).entrySet()) {
                    if (om.getValue() == maxOrderCnt) {
                        orderList.add(om.getKey());
                    }
                }   
            }
        }
        
        Collections.sort(orderList);
        
        return orderList.toArray(new String[0]);
    }
    
    // 조합을 구하는 재귀 함수
    private void combination(int idx, char[] order, String result) {
        if (result.length() >= 2) {
            if (!orderMap.containsKey(result.length())) {
                orderMap.put(result.length(), new HashMap<>());
            }
            
            Map<String, Integer> orders = orderMap.get(result.length());
            
            char[] rArr = result.toCharArray();
            Arrays.sort(rArr);
            String rTemp = new String(rArr);
            
            orders.put(rTemp, orders.getOrDefault(rTemp, 0) + 1);
        }
        
        for (int i = idx; i < order.length;i++) {
            combination(i + 1, order, result + order[i]);
        }
    }
}