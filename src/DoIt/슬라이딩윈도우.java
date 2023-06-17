package DoIt;

// 백준 온라인 저지 12891번 / DNA 비밀번호 문제
// 난이도 : 실버5
// 시간 제한 : 2초
//
// 평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다.
// DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다.
// 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다.
// 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.
// 하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다.
// 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다.
// 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.
// 임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자.
// 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자.
// 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다.
// 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.
// 민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이,
// 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지
// 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자.
// 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.

// 입력 : 첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)
// 두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.
// 세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.

// 출력 : 첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 슬라이딩윈도우 {

    public static void solution() throws IOException {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();   // 임의의 문자열 길이 S
        int P = sc.nextInt();   // 부분문자열의 길이 P

        String str = sc.next(); // 주어진 임의의 문자열 입력
        char[] cArr = str.toCharArray();

        int[] minArr = new int[4];  // 조건배열 입력
        for (int i = 0; i < minArr.length; i++) {
            minArr[i] = sc.nextInt();
        }

        int i = 0;
        int j = P - 1;
        int[] arr = new int[4];
        for (int k = 0; k < P; k++) {    // 주어진 문자열의 분포 배열 생성
            char c = cArr[k];
            sumArr(arr, c);
        }

        int count = 0;
        while(j <= S - 1) {
            if (arr[0] == minArr[0] && arr[1] == minArr[1] && arr[2] == minArr[2] && arr[3] == minArr[3]) {
                count++;
                j++;
            } else if (j + 1 != S){
                char cI = cArr[i];
                char cJ = cArr[++j];
                desArr(arr, cI);
                sumArr(arr, cJ);
            } else {
                j++;
            }
            i++;
        }
        System.out.println(count);
    }

    public static void desArr(int[] arr, char c) {
        if (c == 'A') {
            arr[0]--;
        } else if (c == 'C') {
            arr[1]--;
        } else if (c == 'G') {
            arr[2]--;
        } else if (c == 'T') {
            arr[3]--;
        }
    }

    public static void sumArr(int[] arr, char c) {
        if (c == 'A') {
            arr[0]++;
        } else if (c == 'C') {
            arr[1]++;
        } else if (c == 'G') {
            arr[2]++;
        } else if (c == 'T') {
            arr[3]++;
        }
    }

    static int[] checkArr;
    static int[] myArr;
    static int checkSecret;

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   // 문자열 크기
        int P = Integer.parseInt(st.nextToken());   // 부분 문자열 크기
        int result = 0;

        char[] A = new char[S];         // 받은 문자열
        checkArr = new int[4];    // 조건 배열
        myArr = new int[4];       // 부분 문자열 조건 배열
        checkSecret = 0;            // 만족하는 조건의 개수

        A = br.readLine().toCharArray();    // 받은 문자열 입력

        st = new StringTokenizer(br.readLine());    // A,C,G,T의 개수 조건 배열 입력
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;  // 조건이 0개 이경우 증가
            }
        }

        for (int i = 0; i < P; i++) {   // 첫 부분 문자열 세팅
            Add(A[i]);
        }

        if (checkSecret == 4) result++;
        
        // 슬라이딩 윈도우(두번째 부분 문자열부터)
        for (int i = P; i < S; i++) {
            int j = i - P;  // 범위 유지 : j(첫 인덱스), i(끝 인덱스) -> i가 늘어날때 j도 같이 늘어남
            Add(A[i]);
            Remove(A[j]);

            if (checkSecret == 4) result++;
        }

        System.out.println(result);
        br.close();
    }

    private static void Remove(char c) {
        switch(c) {
            case 'A':
                if (checkArr[0] == myArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (checkArr[1] == myArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (checkArr[2] == myArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (checkArr[3] == myArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkSecret++;
                break;
        }
    }

    public static void main(String[] args) throws IOException {
//        solution();
        solution2();
    }
}
