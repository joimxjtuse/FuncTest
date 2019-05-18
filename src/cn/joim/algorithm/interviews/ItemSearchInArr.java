package cn.joim.algorithm.interviews;

/**
 * 小米三面的一道算法题，虽然题目并不难，但是理解成本挺高的，总感觉这样的思路是不对的。
 * <p>
 * 一个"循环递增"的数组arr,查询一个item所在位置.
 */
public class ItemSearchInArr {


    public static void main(String[] args) {

        int arr[] = {9, 11, 23, 45, 67, 89, 1, 4, 7};
        int searchItem = 1;
        int position = searchItemFrom(arr, searchItem);

        System.out.println("result = " + position);
    }

    private static int searchItemFrom(int arr[], int item) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("invalued input!");
        }
        int result = -1;
        int nStart = 0, nEnd = arr.length - 1;
        int mid;
        while (nStart < nEnd) {

            if (item == arr[nStart]) {
                result = nStart;
                break;
            } else if (item == arr[nEnd]) {
                result = nEnd;
                break;
            }
            mid = nStart + (nEnd - nStart) / 2;

            if (item < arr[mid]) {
                if (item >= arr[nStart]) {
                    nEnd = mid - 1;
                } else {
                    //如果左边的最小值小于item，则item一定在右边.
                    nStart = mid + 1;
                }
            } else if (item > arr[mid]) {
                nStart = mid + 1;
            } else if (item == arr[mid]) {
                result = mid;
                break;
            }

        }
        return result;

    }
}
