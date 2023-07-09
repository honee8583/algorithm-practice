package DoIt;

// 백준 온라인 저지 1541
// 난이도 : 실버2
// 시간 제한 : 2초

// 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
// 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
// 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

// 입력 : 첫째 줄에 식이 주어진다.
// 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
// 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
// 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
// 출력 : 첫째 줄에 정답을 출력한다.

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 그리디_알고리즘2 {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int sum = 0;

        List<String> list = Stream.of(str.split("")).collect(Collectors.toList());
        if (!list.contains("-")) {
            sum = sum(str);
        } else {
            int idx = 0;
            for (String s: str.split("-")) {
                if (idx == 0) {
                    sum += Integer.parseInt(s);
                } else {
                    sum -= sum(s);
                }
                idx++;
            }
        }

        System.out.println(sum);
    }

    public static int sum(String str) {
        int sum = 0;
        for (String s : str.split("[+]")) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }

    public static void main(String[] args) {
        solution();
    }
}
