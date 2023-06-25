package DoIt;

import java.util.*;

public class 기수정렬 {
    public static void radixSort(int[] arr) {

        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queueList.add(queue);
        }

        // 최대값의 자릿수 구하기
        int maxDigit = getMaxLen(arr);

        // 자릿수 만큼 큐에 넣고 Poll하고 배열을 수정하는 과정을 진행
        int digit = 10;
        for (int i = 0; i < maxDigit; i++) {    // 자릿수만큼 반복 i = 자릿수
            for (int j = 0; j < arr.length; j++) {
                // 자릿수에 해당하는 숫자추출
                int num = (int) (arr[j] % digit / (Math.pow(10, i)));   // 123 % 10 = 3 / 1 = 3, 123 % 100 = 23 / 10 = 2
                Queue<Integer> queue = queueList.get(num);
                queue.add(arr[j]);
            }

            // 하나의 자릿수에 대해서 큐에 삽입이 모두 완료된 시점
            int idx = 0;
            for (int j = 0; j < queueList.size(); j++) {
                Queue<Integer> queue = queueList.get(j);
                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
            }

            digit *= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    // 최대 자릿수 구하기
    // int -> Sring -> length()
    public static int getMaxLen(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int count = 0;
        while (max > 0) {
            max = max / 10; // 123 -> 12 -> 1
            count++;
        }

        return count + 1;
    }

    public static void radixSort2(int[] arr) {
        List<Queue<Integer>> queueList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            queueList.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen2(arr);   // 최대자릿수

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                queueList.get(arr[j] / div % 10).offer(arr[j]);
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = queueList.get(j);
                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
            }
            idx = 0;
            div *= 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int getMaxLen2(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int) Math.log10(arr[i]) + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {16, 80, 18, 77, 3, 24, 88, 23};
        radixSort(arr);

        System.out.println();

        arr = new int[]{16, 80, 18, 77, 3, 24, 88, 23};
        radixSort2(arr);
    }
}