package programmers;

import java.util.Arrays;

public class 단어변환 {

    public static int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            System.out.println(0);
            return 0;
        }

        boolean[] visited = new boolean[words.length];

        int cnt = 0;
        int result = DFS(begin, target, words, visited, cnt);

        System.out.println(result);

        return result;
    }

    public static int DFS(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if (begin.equals(target)) {
            return cnt;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            int equal = 0;
            for (int j = 0; j < word.length(); j++) {
                if (begin.charAt(j) == word.charAt(j)) {
                    equal++;
                }
            }

            if (equal == word.length() - 1 && !visited[i]) {
                visited[i] = true;
                min = Math.min(min, DFS(word, target, words, visited, cnt + 1));
                visited[i] = false;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}); // 4
        solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});    // 0
    }
}
