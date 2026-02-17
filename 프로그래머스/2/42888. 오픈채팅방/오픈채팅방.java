import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {        
        Map<String, String> msgs = new HashMap<>();
        msgs.put("Enter", "님이 들어왔습니다.");
        msgs.put("Leave", "님이 나갔습니다.");
        
        Map<String, String> users = new HashMap<>();
        for (String r : record) {
            String[] cmds = r.split(" ");
            if (cmds.length == 3) {
                users.put(cmds[1], cmds[2]);
            }
        }
    
        // System.out.println(users);
        
        List<String> result = new ArrayList<>();
        for (String r : record) {
            String[] cmds = r.split(" ");
            if (msgs.containsKey(cmds[0])) {  // Enter/Leave
                result.add(users.get(cmds[1]) + msgs.get(cmds[0]));
            }
        }
        
        return result.toArray(new String[0]);
    }
} 