package cn.joim.algorithm.array;

/**
 * 有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变;
 * 要求时间复杂度为O(n), 空间复杂度为O(1)。
 * 例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35},
 * 变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}。
 *
 * 看起来这个题目在百度和头条的面试中出现过。
 */
public class MoveItem {

    public void handleMove(int arrays[]) {
        if (arrays == null || arrays.length <= 1) {
            return;
        }
        //找到第一个正数的位置positivePosition，每次找到一个负数negativePosition，把
        //[positivePosition， negativePosition）右移一位，将negativePosition的数据
        //放到原positivePosition位置.
        int nFirstPositivePosition = -1, negativePosition = -1;

        //因程序未做标识，故认为0按正数处理。
        for (int i = 0; i < arrays.length; i++) {

            if (nFirstPositivePosition == -1 || negativePosition == -1) {
                if (arrays[i] >= 0 && nFirstPositivePosition == -1) {
                    nFirstPositivePosition = i;
                } else if (arrays[i] < 0 && negativePosition == -1) {
                    negativePosition = i;
                }
            }

            if (nFirstPositivePosition != -1 && negativePosition != -1) {

                //negativePosition > nFirstPositivePosition.
                int temp = arrays[negativePosition];
                for (int j = negativePosition; j > nFirstPositivePosition; j--) {
                    arrays[j] = arrays[j - 1];
                }
                arrays[nFirstPositivePosition] = temp;
                nFirstPositivePosition++;

                negativePosition = -1;
            }

        }

    }

    public static void main(String[] args) {
        int array[] = {10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
        printArr(array);
        new MoveItem().handleMove(array);
        printArr(array);
    }

    private static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();

    }
}
