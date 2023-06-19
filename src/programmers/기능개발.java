package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int k = 0;

        int temp = getLeftDate(progresses, speeds, 0);
        list.add(1);
        for (int i = 1; i < progresses.length; i++) {
            int leftDate = getLeftDate(progresses, speeds, i);
            if (leftDate <= temp) {   // 다음 기능개발에 걸리는 시간이 첫기능개발기간보다 적을 경우
                list.set(k, list.get(k) + 1);
            } else {
                list.add(1);
                temp = leftDate;
                k++;
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public static int getLeftDate(int[] progresses, int[] speeds, int i) {
        return (100 - progresses[i]) % speeds[i] != 0 ?
                (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i];
    }

    public static void main(String[] args) {
        int[] result = solution(new int[]{95,90,99,99,80,99}, new int[]{1,1,1,1,1,1});
        Arrays.stream(result).forEach(System.out::print);

        System.out.println();

        int[] result2 = solution(new int[]{93,30,55}, new int[]{1,30,5});
        Arrays.stream(result2).forEach(System.out::print);
    }
}
