import java.util.*;
import java.io.*;

public class Main {
    static final String FAIL = " is not acceptable.\n";
    static final String SUCCESS = " is acceptable.\n";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character> consonants = List.of('a', 'e', 'i', 'o', 'u');


        while(true) {
            String word = br.readLine();

            if (word.equals("end")) {
                break;
            }

            char[] cArr = word.toCharArray();

            boolean hasConsonant = false;
            for (int i = 0; i < cArr.length; i++) {
                char c = cArr[i];

                // 모음 포함 여부
                if (consonants.contains(c)) {
                    hasConsonant = true;
                }

                // 이전 문자와 동일한 경우
                if (i >= 1 && c == cArr[i - 1]) {
                    if (c != 'o' && c != 'e') {
                        bw.write(fail(word));
                        break;
                    }
                }

                if (i >= 2) {
                    // 이전, 현재가 모두 모음일 경우
                    if (consonants.contains(c) && consonants.contains(cArr[i - 1]) && consonants.contains(cArr[i - 2])) {
                        bw.write(fail(word));
                        break;
                    } else if (!consonants.contains(c) && !consonants.contains(cArr[i - 1]) && !consonants.contains(cArr[i - 2])) {
                        // 이전, 현재가 모두 자음일 경우
                        bw.write(fail(word));
                        break;
                    }
                }

                // 마지막 까지 온경우
                if (i == cArr.length - 1) {
                    if (!hasConsonant) {
                        bw.write(fail(word));
                    } else {
                        bw.write(success(word));
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static String success(String word) {
        return "<" + word + ">" + SUCCESS;
    }

    public static String fail(String word) {
        return "<" + word + ">" + FAIL;
    }
}
