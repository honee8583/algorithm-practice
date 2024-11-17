package 백준.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B_2751 {
    static int[] arr, tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        tmp = new int[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(0, N - 1);

        for (int i = 0; i < N; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int s, int e) {
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
            if (tmp[i] < tmp[j]) {
                arr[idx] = tmp[i++];
                idx++;
            } else {
                arr[idx] = tmp[j++];
                idx++;
            }
        }

        while (i <= mid) {
            arr[idx] = tmp[i++];
            idx++;
        }
        while (j <= e) {
            arr[idx] = tmp[j++];
            idx++;
        }
    }
}
