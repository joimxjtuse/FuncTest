package cn.joim.algorithm.sort;

public class QuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {

        /**
         * 面试的时候考到了基本的快排算法，实在没太手写这些基本的算法，虽然思路还在，但回家后回忆下还是有问题.
         * */
        // review for quick sort.
        int nInput[] = {3, 6, 8, 2, 0, 4, 8};
        if (nInput == null || nInput.length <= 1) {
            return;
        }
        printArray(nInput);
        quickSort(nInput);
        printArray(nInput);
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    static void quickSort(int nInput[]) {

        quickSort(nInput, 0, nInput.length - 1);
    }

    static void quickSort(int nInput[], int nLow, int nHigh) {

        int nPosition = findLowItemPosition(nInput, nLow, nHigh);

        if (nPosition - 1 > nLow) {
            quickSort(nInput, nLow, nPosition - 1);
        }

        if (nPosition + 1 < nHigh) {
            quickSort(nInput, nPosition + 1, nHigh);
        }

    }

    static int findLowItemPosition(int nInput[], int nLow, int nHigh) {

        int i = nLow, j = nHigh;
        int nItem = nInput[i];

        while (i < j) {

            while (i < j && nItem <= nInput[j]) {
                j--;
            }

            if (i < j) {
                nInput[i] = nInput[j];
            }

            while (i < j && nItem >= nInput[i]) {
                i++;
            }
            if (i < j) {
                nInput[j] = nInput[i];
            }
        }
        nInput[i] = nItem;

        return i;
    }
}
