package DoIt;

public class 병합정렬 {
    public static void mergeSort(int[] arr,int[] result, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, result, left, mid);
            mergeSort(arr, result, mid + 1, right);

            merge(arr, result, left, right, mid);
        }
    }

    public static void merge(int[] arr, int[] result, int left, int right, int mid) {
        int i = left;
        int j = mid + 1;
        int idx = left;

        // 중요한 부분
        while (i <= mid || j <= right) {
            if (i <= mid && j <= right) {   // 좌측, 우측 서브배열 모두 원소가 남은 상태인 경우
                if (arr[i] <= arr[j]) {
                    result[idx++] = arr[i++];
                } else {
                    result[idx++] = arr[j++];
                }
            } else if (i <= mid && j > right) { // 좌측 서브배열에만 원소가 남은 경우(오른쪽 서브배열은 정렬이 모두 완료된경우)
                result[idx++] = arr[i++];
            } else {                            // 우측 서브배열에만 원소가 남은 경우
                result[idx++] = arr[j++];
            }
        }

        for (int k = left; k <= right; k++) {
            arr[k] = result[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{42, 32, 24, 60, 15, 5, 90, 45};
        int[] result = new int[arr.length];
        mergeSort(arr, result, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
