package 백준.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_11931 {
    static int N;
    static int[] arr, tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tmp = new int[N];
        mergeSort(0, N - 1);

        for (int n : arr) {
            System.out.println(n);
        }
    }

    private static void mergeSort(int s , int e) {
        if (e - s < 1) {
            return;
        }

        int mid = s + (e - s) / 2;
        mergeSort(s, mid);
        mergeSort(mid + 1, e);

        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }

        int idx = s;
        int i = s;
        int j = mid + 1;
        while (i <= mid && j <= e) {
            if (tmp[i] < tmp[j] && idx <= e) {
                arr[idx] = tmp[j++];
            } else {
                arr[idx] = tmp[i++];
            }
            idx++;
        }

        while (i <= mid) {
            arr[idx++] = tmp[i++];
        }

        while (j <= e) {
            arr[idx++] = tmp[j++];
        }
    }
}
