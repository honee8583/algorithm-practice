package 백준.그래프.DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B_2023 {
    static int N;
    static List<Integer> primeList;
    static List<Integer> list = List.of(1, 3, 7, 9);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        primeList = new ArrayList<>();
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        Collections.sort(primeList);

        for (int p : primeList) {
            System.out.println(p);
        }
    }

    public static void DFS(int num, int cnt) {
        if (cnt >= N) {
            if (isPrime(num)) {
                primeList.add(num);
            }
            return;
        }

        for (int l : list) {
            if (isPrime(num * 10 + l)) {
                DFS(num * 10 + l, cnt + 1);
            }
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
