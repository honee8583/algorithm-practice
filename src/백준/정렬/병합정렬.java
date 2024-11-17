package 백준.정렬;

import java.util.Arrays;

public class 병합정렬 {
    static int[] arr = new int[] {42, 32, 24, 60, 15, 5, 90, 45};
    static int[] tmp;

    public static void main(String[] args) {
        tmp = new int[arr.length];
        mergeSort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int i, int j) {
        if (j - i < 1) {
            return;
        }

        int mid = i + (j - i) / 2;
        mergeSort(i, mid);
        mergeSort(mid + 1, j);

        for (int k = i; k <= j; k++) {
            tmp[k] = arr[k];
        }

        int idx = i;
        int s = i;
        int e = mid + 1;
        while (s <= mid && e <= j) {
            if (tmp[s] < tmp[e]) {
                arr[idx] = tmp[s];
                s++;
                idx++;
            } else {
                arr[idx] = tmp[e];
                e++;
                idx++;
            }
        }

        while (s <= mid) {
            arr[idx] = tmp[s];
            s++;
            idx++;
        }

        while (e <= j) {
            arr[idx] = tmp[e];
            e++;
            idx++;
        }
    }
}
