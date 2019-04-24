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
        //[low,mid) 以及[mid,high]是两个已经排好序的子序列
        //只需要把它们的按顺序进行排序即可.
        int nLowPosition = low, nHighPosition = mid + 1;
        int tempArr[] = new int[high - low + 1];
        int i = 0;
        while (nLowPosition <= mid && nHighPosition <= high) {
            if (array[nLowPosition] > array[nHighPosition]) {
                tempArr[i++] = array[nHighPosition++];
            } else {
                tempArr[i++] = array[nLowPosition++];
            }
        }

        while (nLowPosition <= mid) {
            tempArr[i++] = array[nLowPosition++];
        }
        while (nHighPosition <= high) {
            tempArr[i++] = array[nHighPosition++];
        }

        for (i = 0; i < tempArr.length; i++) {
            array[i + low] = tempArr[i];
        }
    }
}
