package leetcode.sort;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-08-05
 **/
public class QuickSort {
    public static void quickSort(int []arr) {

    }

    public static void main(String []args) {
        int []arr = {1, 3, 8, 2, 0, 5, 6, 4, 9, 7};
        quickSort(arr);
        for (int e : arr) {
            System.out.printf("%d ", e);
        }
        System.out.println();
    }
}
