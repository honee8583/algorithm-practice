package 백준.슬라이딩윈도우;

import java.io.*;
import java.util.*;

public class B_12891 {
    static int[] cnt;
    static String[] word;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int subLength = Integer.parseInt(st.nextToken());

        word = br.readLine().split("");

        st = new StringTokenizer(br.readLine());
        int[] count = new int[4];
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 슬라이딩 윈도우의 구성 문자열 분석
        cnt = new int[4];
        for (int k = 0; k < subLength; k++) {
            if (word[k].equals("A")) {
                cnt[0]++;
            } else if (word[k].equals("C")) {
                cnt[1]++;
            } else if (word[k].equals("G")) {
                cnt[2]++;
            } else {
                cnt[3]++;
            }
        }

        int i = 0;
        int j = i + subLength - 1;
        int answer = 0;
        while (j < length) {
            // 현재 슬라이딩 윈도우 검사
            boolean flag = true;
            for (int k = 0; k < 4; k++) {
                if (cnt[k] < count[k]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;

            // 다시 반복문을 통해 맞는 글자의 수를 차감하는 방식이 아닌
            // i와 j + 1 인덱스의 값만 비교해서 수정!!
            if (i < length && j < length - 1) {
                add(i);
                remove(j + 1);
            }

            i++;
            j++;
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void add(int idx) {
        String s = word[idx];
        if (s.equals("A")) {
            cnt[0]++;
        } else if (s.equals("C")) {
            cnt[1]++;
        } else if (s.equals("G")) {
            cnt[2]++;
        } else {
            cnt[3]++;
        }
    }

    public static void remove(int idx) {
        String s = word[idx];
        if (s.equals("A")) {
            cnt[0]--;
        } else if (s.equals("C")) {
            cnt[1]--;
        } else if (s.equals("G")) {
            cnt[2]--;
        } else {
            cnt[3]--;
        }
    }
}
