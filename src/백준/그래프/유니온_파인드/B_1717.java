package 백준.그래프.유니온_파인드;

import java.util.Arrays;
import java.util.Scanner;

public class B_1717 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 배열 초기화
        arr = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 연산 입력(0: union, 1: find)
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0) {
                union(b, c);
            } else {
                if (find(b) == find(c)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }

//        System.out.println(Arrays.toString(arr));
    }

    public static void union(int a , int b) {
        int parentA = find(a);  // a의 대표노드
        int parentB = find(b);  // b의 대표노드

        if (parentA < parentB) {
            arr[parentB] = parentA;
        } else if (parentA > parentB){
            arr[parentA] = parentB;
        }
    }

    public static int find(int num) {
        if (arr[num] == num) {
            return num;
        }

        return arr[num] = find(arr[num]);   // ** 중요 포인트: 대표노드를 찾기 위해 방문한 자식노드들의 값을 대표노드로 지정해준다. (시간복잡도 단축)
    }
}
