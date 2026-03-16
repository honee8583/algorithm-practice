import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n) {
        int size = 0;
        for (int i= 1;i <= n;i++) {
            size += i;
        }
        
        int[][] arr = new int[n][n];
        arr[0][0] = 1;
        int x = 0;
        int y = 0;
        while (true) {
            boolean flag = true;
            
            // 맨 밑으로 이동
            while (x < n - 1) {
                // System.out.println(x + ", " + y);
                if (arr[x + 1][y] > 0) break;
                arr[x + 1][y] = arr[x][y] + 1;
                flag = false;
                x++;
            }
            
            // 맨 오른쪽으로 이동
            while (y < n - 1) {
                // System.out.println(x + ", " + y);
                if (arr[x][y + 1] > 0) break;
                arr[x][y + 1] = arr[x][y] + 1;
                flag = false;
                y++;
            }
            
            // 왼쪽 대각선으로 이동
            while (x > 0 && y > 0) {
                // System.out.println(x + ", " + y);
                if (arr[x - 1][y - 1] > 0) break;
                arr[x - 1][y - 1] = arr[x][y] + 1;
                flag = false;
                x--;
                y--;
            }
            
            if (flag) {
                break;
            }
        }
        
        int[] answer = new int[size];
        int idx = 0;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j <= i;j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}