package 백준.정렬;

import java.util.Arrays;

public class 퀵정렬 {
    static int[] arr = new int[] {42, 32, 24, 60, 15, 5, 90, 45};

    public static void main(String[] args) {
        quickSort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        // i == j일때까지 반복
        while (i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            while (arr[i] <= pivot && i < j) {
                i++;
            }
            swap(i, j); // i == j여도 상관없음 제자리
        }

        swap(left, i);

        return i;
    }

    private static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partition(left, right);
        quickSort(left, p - 1);
        quickSort(p + 1, right);
    }

    private static void swap(int x, int y) {
        int tmp = arr[y];
        arr[y] = arr[x];
        arr[x] = tmp;
    }
}
