import java.util.*;
import java.util.stream.*;
import java.io.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> ponketmons = new HashSet<>();
        Arrays.stream(nums).forEach(n -> ponketmons.add(n));
        
        if (ponketmons.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = ponketmons.size();
        }
        
        return answer;
    }
}