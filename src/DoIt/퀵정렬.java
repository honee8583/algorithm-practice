package DoIt;

import java.util.Arrays;

public class 퀵정렬 {
    public static void quickSort(int[] arr, int left, int right) {
        // 종료조건
        if (left >= right) {
            return;
        }

        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    // arr[i], arr[j]의 값을 Pivot값과 비교하여 이동한후 pivot과 swap후 최종 새로운 pivot을 반환할때까지의 과정
    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        int j = right - 1;

        while (i < j) {
            while (arr[i] < pivot && i < j) {
                i++;
            }

            while (arr[j] > pivot && i < j) {
                j--;
            }

            swap(arr, i, j);
        }

        swap(arr, right, i);

        return i;
    }

    public static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{42,32,24,60,15,5,90,45};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
