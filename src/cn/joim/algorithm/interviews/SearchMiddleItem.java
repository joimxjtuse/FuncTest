package cn.joim.algorithm.interviews;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 4. 寻找两个有序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class SearchMiddleItem {


    public static void main(String[] args) {
        int array1[] = {1, 3, 5, 7, 9, 11, 13, 15};
        int array2[] = {2, 4, 6, 8, 10};
        //1, 2, 3, 4, 5, 6, 7, 8, 9,  11, 13, 15

        System.out.println("result =  " + new SearchMiddleItem().findMedianSortedArrays(array1, array2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //nums1 nums2

        if (nums1 == null && nums2 == null) {
            throw new RuntimeException("error input");
        } else if (nums1 == null) {
            int center = nums2.length / 2;
            if (nums2.length % 2 == 0) {
                center--;
            } else {
                center++;
            }

            return nums2[center];
        } else if (nums2 == null) {
            int center = nums1.length / 2;
            if (nums1.length % 2 == 0) {
                center--;
            } else {
                center++;
            }
            return nums2[center];
        }
        int length1 = nums1 != null ? nums1.length : 0;
        int length2 = nums2 != null ? nums2.length : 0;

        int result = 0;
        int centerPosition = (length1 + length2) / 2;
        if ((length1 + length2) % 2 == 0) {
            centerPosition--;
        } else {
            centerPosition++;
        }


        int leftPosition = 0, rightPosition = 0;

        for (int i = 0; i < centerPosition; i++) {
            int leftItem = Integer.MIN_VALUE, rightItem = Integer.MIN_VALUE;

            if (leftPosition < length1) {
                leftItem = nums1[leftPosition];
            }
            if (rightPosition < length2) {
                rightItem = nums2[rightPosition];
            }

            if (leftItem < rightItem && leftItem != Integer.MIN_VALUE) {
                leftPosition++;
                result = leftItem;

            } else if (leftItem >= rightItem && rightPosition != Integer.MIN_VALUE) {
                rightPosition++;
                result = rightItem;
            } else if (leftItem != Integer.MIN_VALUE) {
                leftPosition++;
                result = leftItem;
            } else if (rightPosition != Integer.MIN_VALUE) {
                rightPosition++;
                result = rightItem;
            }
        }
        return result;
    }


}
