package 백준.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무의 개수
        int M = Integer.parseInt(st.nextToken());   // 필요한 나무의 길이

        int[] A = new int[N];   // 나무 길이 배열
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = Arrays.stream(A).max().getAsInt();
        while (start <= end) {
            int mid = (start + end) / 2;    // 톱날의 길이

            long sum = 0;   // long 타입으로 선언해줘야 한다.
            for(int tree: A) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            // 만든 나무의 총 길이가 목표 나무의 길이보다 길 경우
            if (sum < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}
