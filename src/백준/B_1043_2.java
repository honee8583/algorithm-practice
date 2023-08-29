package 백준;

import java.util.ArrayList;
import java.util.Scanner;

public class B_1043_2 {
    public static int result;
    public static int[] trueP;  // 진실을 아는 사람 리스트
    public static ArrayList<Integer>[] party;
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 파티 참가자 인원
        int M = sc.nextInt();   // 파티 수
        int T = sc.nextInt();   // 진실을 아는 사람 수
        result = 0;

        trueP = new int[T];
        for (int i = 0; i < T; i++) {
            trueP[i] = sc.nextInt();
        }

        party = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<Integer>();
            int party_size = sc.nextInt();
            for (int j = 0; j < party_size; j++) {
                party[i].add(sc.nextInt());
            }
        }

        // 대표노드를 자기 자신으로 초기화
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        // 각 파티에 참여한 사람들을 1개의 그룹으로 만들기
        for (int i = 0; i < M; i++) {
            int firstPeople = party[i].get(0);  // 각 파티의 첫번재 사람을 대표노드로 지정
            for (int j = 1; j < party[i].size(); j++) {
                // ** Union: 하나의 파티내의 파티원들을 하나의 대표노드로 지정
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i = 0; i < M; i++) {
            boolean isPossible = true;
            int cur = party[i].get(0);  // 첫번째 파티원
            for (int j = 0; j < trueP.length; j++) {
                if (find(cur) == find(trueP[j])) {  // 각 파티의 대표노드가 진실을 아는 사람 리스트의 대표노드와 동일할 경우
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
