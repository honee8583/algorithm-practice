import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();

        List<String> sArr = new ArrayList<>();
        String[] arr = A.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String cur = arr[i];

            if (!cur.equals("+") && !cur.equals("-")) {
                sb.append(cur);
            } else {
                sArr.add(sb.toString());
                sArr.add(cur);
                sb = new StringBuilder();
            }
        }
        sArr.add(sb.toString());

        // System.out.println(sArr.toString());

        int sum = Integer.parseInt(sArr.get(0));
        int tmp = 0;
        for (int i = 1; i < sArr.size(); i+=2) {
            String a = sArr.get(i);
            int num = Integer.parseInt(sArr.get(i + 1));

            if (a.equals("-")) {
                sum -= tmp;
                tmp = num;
            } else {
                if (tmp != 0) {
                    tmp += num;
                } else {
                    sum += num;
                }
            }
        }
        sum -= tmp;

        System.out.println(sum);
    }
}