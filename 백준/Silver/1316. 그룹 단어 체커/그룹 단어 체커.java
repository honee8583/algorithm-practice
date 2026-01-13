import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        int total = 0;
        for (int i = 0;i < T;i++) {
            String str = sc.nextLine();

            boolean[] visited = new boolean[26];
            boolean flag = true;
            for (int j = 0;j < str.length();j++) {
                int idx = str.charAt(j) - 'a';

                if (j > 0) {
                    // 두번째 문자~
                    if (str.charAt(j - 1) == str.charAt(j)) {
                        // 이전과 같은 문자인 경우
                        // 검사x
                        continue;
                    } else {
                        // 이전과 다른 문자고 이미 방문한적이 있는 경우
                        if (visited[idx]) {
                            flag = false;
                            break;
                        }
                    }
                }

                visited[idx] = true;
            }

            if (flag) {
                total++;
            }
        }

        System.out.println(total);
    }
}