package 백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B_1043 {
    static int[] partyAttendants;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 파티참가자수
        int M = sc.nextInt();   // 파티 수

        // 진실을 아는 사람들 리스트
        int known = sc.nextInt();   // 진실을 아는 사람의 수(0일수도 있음)
        List<Integer> knownList = new ArrayList<>();
        for (int i = 0; i < known; i++) {
            knownList.add(sc.nextInt());
        }

        // 파티 구성
        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int cnt = sc.nextInt();

            int[] people = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                people[j] = sc.nextInt();
            }

            parties.add(people);
        }

        result = 0;

        // 사람 배열 초기화
        partyAttendants = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            partyAttendants[i] = i;
        }

        // 대표 노드로 union 수행
        for (int i = 0; i < parties.size(); i++) {
            int firstNode = parties.get(i)[0];
            for (int j = 0; j < parties.get(i).length; j++) {
                union(firstNode, parties.get(i)[j]);
            }
        }

        // 각 파티 검사
        for (int i = 0; i < parties.size(); i++) {
            int cur = parties.get(i)[0];
            boolean flag = true;
            for (int j = 0; j < knownList.size(); j++) {
                if (find(cur) == find(knownList.get(j))) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            partyAttendants[b] = a;
        }
    }

    public static int find(int node) {
        if (partyAttendants[node] == node) {
            return node;
        }

        return partyAttendants[node] = find(partyAttendants[node]);
    }
}
