import java.util.*;

public class Solution {
    public int solution(int n) {
        // int[] dp = new int[n + 1];
        // dp[1] = 1;
        // for (int i = 2;i <= n;i++) {
        //     if (i % 2 == 0) {
        //         dp[i] = Math.min(dp[i / 2], dp[i - 1] + 1);
        //     } else {
        //         dp[i] = dp[i - 1] + 1;
        //     }
        // }
        
        int result = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                n -= 1;
                result++;
            } else {
                n = n / 2;
            }
        }
        
        return result;
    }
}