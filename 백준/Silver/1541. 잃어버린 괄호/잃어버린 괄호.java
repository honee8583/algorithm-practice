import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int sum = Integer.MAX_VALUE;
		String[] subtraction = sc.nextLine().split("-");

        // 뺄셈 기준으로 split하게 되면 숫자, +를 포함 숫자로 나뉘게 됩니다.
        // +를 포함한 숫자들은 같이 더해서 한번에 빼줍니다.
        // 즉, split을 적절하게 잘 사용하면 쉽게 해결할 수 있습니다.
		for(int i = 0; i < subtraction.length; i++) {
			int temp = 0;
 
			String[] addition = subtraction[i].split("\\+");
			
			for(int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			// 첫 번째 숫자일 경우
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else { // 그 다음 숫자일 경우
				sum -= temp;
			}
		}

		System.out.println(sum);
	}
}