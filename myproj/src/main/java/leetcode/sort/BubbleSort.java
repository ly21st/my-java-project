package leetcode.sort;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-08-05
 **/
public class BubbleSort {
    public static void bubbleSort(int []arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String []args) {
        int []arr = {1, 3, 8, 2, 0, 5, 6, 4, 9, 7};
        bubbleSort(arr);
        for (int e : arr) {
            System.out.printf("%d ", e);
        }
        System.out.println();
    }
}
