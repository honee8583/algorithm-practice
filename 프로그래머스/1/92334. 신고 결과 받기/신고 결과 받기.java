import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 유저별 인덱스
        Map<String, Integer> users = new HashMap<>();
        for (int i = 0;i < id_list.length;i++) {
            users.put(id_list[i], i);
        }
        
        Map<String, List<String>> reportUserMap = new HashMap<>();  // 유저별 신고대상자 리스트
        // Map<String, Integer> reportCntMap = new HashMap<>();        // 유저별 누적 신고 횟수
        Map<String, Set<String>> respondentUserMap = new HashMap<>();  // 신고대상자별 신고자 리스트(중복 신고 방지)
        for (String r : report) {
            String[] detail = r.split(" ");
            String reporter = detail[0];
            String respondent = detail[1];
            
            // 신고대상자별 신고자 리스트 업데이트
            if (!respondentUserMap.containsKey(respondent)) {
                // respondentUserMap.put(respondent, new ArrayList<>(Arrays.asList(reporter)));
                respondentUserMap.put(respondent, new HashSet<>(Arrays.asList(reporter)));
            } else {
                // 신고한적 없는 신고자일경우에 추가
                // if (!respondentUserMap.get(respondent).contains(reporter)) {
                respondentUserMap.get(respondent).add(reporter);
                // }
            }
            
            // 신고자별 신고대상자 리스트 업데이트
            if (!reportUserMap.containsKey(reporter)) {
                reportUserMap.put(reporter, new ArrayList<>(Arrays.asList(respondent)));
            } else {
                reportUserMap.get(reporter).add(respondent);
            }
            
            
            // reportCntMap.put(respondent, reportCntMap.getOrDefault(respondent, 0) + 1);
        }
        
        int[] answer = new int[id_list.length];
        for (String respondent : respondentUserMap.keySet()) {
            if (respondentUserMap.get(respondent).size() >= k) {
                
                for (String reporter : reportUserMap.keySet()) {
                    if (reportUserMap.get(reporter).contains(respondent)) {
                        // 메일을 날린다.
                        answer[users.get(reporter)]++;
                    }
                }
                
            }
        }
        
        return answer;
    }
}