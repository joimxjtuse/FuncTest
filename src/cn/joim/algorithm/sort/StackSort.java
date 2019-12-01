package cn.joim.algorithm.sort;

/**
 * 堆排序.
 * <p>
 * 堆排序是一种树形选择排序方法，它的特点是：在排序的过程中，将array[0，...，n-1]看成是一颗
 * 完全二叉树的顺序存储结构，利用完全二叉树中双亲节点和孩子结点之间的内在关系，在当前无序区中
 * 选择关键字最大（最小）的元素。
 * <p>
 * 过程：
 * ①将存放在array[0，...，n-1]中的n个元素建成初始堆；
 * ②将堆顶元素与堆底元素进行交换，则序列的最大值即已放到正确的位置；
 * ③但此时堆被破坏，将堆顶元素向下调整使其继续保持大根堆的性质，再重复第②③步，直到堆中仅剩下一个元素为止。
 * <p>
 * 堆排序算法的性能分析：
 * <p>
 * 　　空间复杂度:o(1)；
 * 　　时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);
 * 　　稳定性：不稳定
 */
public class StackSort {

    public static void main(String[] args) {
        int nInput[] = {3, 6, 8, 2, 0, 4, 8};
        printArr(nInput);
        new StackSort().sort(nInput);
        printArr(nInput);
    }

    private static void printArr(int[] a) {

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public void sort(int array[]) {

        buildBigRootStack(array);
        printArr(array);
        for (int i = array.length - 1; i >= 1; i--) {

            //将堆顶元素和堆低元素交换，即得到当前最大元素正确的排序位置
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            adjustDownToUp(array, 0, i);  //整理，将剩余的元素整理成堆
            printArr(array);
        }
    }

    private void buildBigRootStack(int array[]) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
    }

    //将元素array[k]自下往上逐步调整树形结构
    private void adjustDownToUp(int[] array, int k, int length) {
        int temp = array[k];
        for (int i = 2 * k + 1; i <= length - 1; i = 2 * i + 1) {    //i为初始化为节点k的左孩子，沿节点较大的子节点向下调整
            if (i < length && array[i] < array[i + 1]) {  //取节点较大的子节点的下标
                i++;   //如果节点的右孩子>左孩子，则取右孩子节点的下标
            }
            if (temp >= array[i]) {  //根节点 >=左右子女中关键字较大者，调整结束
                break;
            } else {   //根节点 <左右子女中关键字较大者
                array[k] = array[i];  //将左右子结点中较大值array[i]调整到双亲节点上
                k = i; //【关键】修改k值，以便继续向下调整
            }
        }
        array[k] = temp;  //被调整的结点的值放人最终位置
    }


}
