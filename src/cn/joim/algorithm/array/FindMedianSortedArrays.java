package cn.joim.algorithm.array;

/***
 *
 * 4. 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int nums1[] = {};

        int nums2[] = {2, 3};

        double result = new FindMedianSortedArrays()
                .findMedianSortedArrays(nums1, nums2);
        System.out.println("result = " + result);

    }


    /**
     * 我们理解什么中位数：指的是该数左右个数相等
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //如果其中一个是空，则另一个的中位.
        int length1 = nums1 != null ? nums1.length : 0;
        int length2 = nums2 != null ? nums2.length : 0;


        int length = length1 + length2;

        int position = length / 2;
        boolean calcCenter = length % 2 == 0;

        /**
         * 如果是基数，则length/2即为中位数；
         * 如果是偶数，则length/2，length/2 - 1 位置的平均值即为中位数
         * */
        int nStart = 0;
        int firItem = 0, secItem = 0;

        int point1 = 0, point2 = 0;

        while (nStart <= position) {
            //if (nItem <)
            firItem = secItem;
            if (point1 < length1 && point2 < length2) {
                if (nums1[point1] < nums2[point2]) {
                    secItem = nums1[point1];
                    point1++;
                } else {
                    secItem = nums2[point2];
                    point2++;
                }
            } else if (point1 < length1) {
                secItem = nums1[point1];
                point1++;
            } else {
                secItem = nums2[point2];
                point2++;
            }
            nStart++;

        }

        if (calcCenter) {
            return (firItem + secItem) / 2.0;
        } else {
            return secItem;
        }

        //return item;
    }
}
