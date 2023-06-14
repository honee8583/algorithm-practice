package programmers;

import java.util.Arrays;

public class 비밀지도1 {
    private static String[] toBinaryCode(int n, int[] arr) {
        String[] str = new String[n];
        for (int i = 0; i < arr.length; i++) {
            String binary = Integer.toBinaryString(arr[i]);
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            str[i] = binary;
        }

        return str;
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {

        // 이진수로 변환
        String[] str1 = toBinaryCode(n, arr1);

        String[] str2 = toBinaryCode(n, arr2);

        // 비교
        String[] result = new String[n];
        for (int i = 0; i < result.length; i++) {
            StringBuilder sb = new StringBuilder();

            char[] cArr1 = str1[i].toCharArray();
            char[] cArr2 = str2[i].toCharArray();

            for (int j = 0; j < cArr1.length; j++) {
                if (cArr1[j] == '1' || cArr2[j] == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            result[i] = sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};
//        System.out.println(solution(5, arr1, arr2));    // ["#####", "# # #", "### #", "# ##", "#####"]

        String[] result = solution(5, arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }
}
