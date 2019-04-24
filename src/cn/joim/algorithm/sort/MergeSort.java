package cn.joim.algorithm.sort;

/**
 * 归并排序.
 * <p>
 * 　　归并排序 (merge sort) 是一类与插入排序、交换排序、选择排序不同的另一种排序方法。
 * 归并的含义是将两个或两个以上的有序表合并成一个新的有序表。归并排序有多路归并排序、两路
 * 归并排序 , 可用于内排序，也可以用于外排序。这里仅对内排序的两路归并方法进行讨论。
 * <p>
 * 一、两路归并排序算法思路
 * <p>
 * 分而治之(divide - conquer);每个递归过程涉及三个步骤
 * 第一, 分解: 把待排序的 n 个元素的序列分解成两个子序列, 每个子序列包括 n/2 个元素.
 * 第二, 治理: 对每个子序列分别调用归并排序MergeSort, 进行递归操作
 * 第三, 合并: 合并两个排好序的子序列,生成排序结果.
 */
public class MergeSort {

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int array[] = {49, 38, 65, 97, 76, 13, 27, 100, 5};
        printArray(array);
        new MergeSort().sort(array);
        printArray(array);

    }

    public void sort(int array[]) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int array[], int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {

            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            //左右归并
            merge(array, low, mid, high);
        }
    }

    private void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = array[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int x = 0; x < temp.length; x++) {
            array[x + low] = temp[x];
        }
    }
}
