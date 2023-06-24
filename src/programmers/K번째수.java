package programmers;

import java.util.Arrays;

public class K번째수 {

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for (int i = 0; i < commands.length; i++) {
            int[] A = commands[i];

            int bIdx = 0;
            int[] B = new int[A[1] - A[0] + 1];
            for (int j = A[0] - 1; j < A[1]; j++) {
                B[bIdx++] = array[j];
            }

            Arrays.sort(B);
            answer[idx++] = B[A[2] - 1];
        }

        return answer;
    }

    public static int[] solution2(int[] array, int[][] commands) {
        // copyOfRange()
        int[] result = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tempArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(tempArr);
            result[i] = tempArr[commands[i][2] - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        int[] result = solution(array, commands);    // 5,6,3
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println();

        int[] result2 = solution2(array, commands);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
    }
}
