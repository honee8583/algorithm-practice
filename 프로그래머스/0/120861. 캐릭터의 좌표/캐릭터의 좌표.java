import java.util.*;
import java.io.*;

class Solution {
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {1, -1, 0, 0};
    
    public int[] solution(String[] keyinput, int[] board) {
        int[] cur = new int[] {0, 0};
        
        int xMin = board[0] / 2 * (-1);
        int xMax = board[0] / 2;
        int yMin = board[1] / 2 * (-1);
        int yMax = board[1] / 2;
        for (String input : keyinput) {
            if (input.equals("left")) {
                int nextX = cur[0] + dx[2];
                int nextY = cur[1] + dy[2];
                if (nextX <= xMax && nextX >= xMin && nextY <= yMax && nextY >= yMin) {
                    cur[0] = nextX;
                    cur[1] = nextY;
                }
            } else if (input.equals("right")) {
                int nextX = cur[0] + dx[3];
                int nextY = cur[1] + dy[3];
                if (nextX <= xMax && nextX >= xMin && nextY <= yMax && nextY >= yMin) {
                    cur[0] = nextX;
                    cur[1] = nextY;
                }
            } else if (input.equals("up")) {
                int nextX = cur[0] + dx[0];
                int nextY = cur[1] + dy[0];
                if (nextX <= xMax && nextX >= xMin && nextY <= yMax && nextY >= yMin) {
                    cur[0] = nextX;
                    cur[1] = nextY;
                }
            } else {
                int nextX = cur[0] + dx[1];
                int nextY = cur[1] + dy[1];
                if (nextX <= xMax && nextX >= xMin && nextY <= yMax && nextY >= yMin) {
                    cur[0] = nextX;
                    cur[1] = nextY;
                }
            }
        }
        
        return cur;
    }
}