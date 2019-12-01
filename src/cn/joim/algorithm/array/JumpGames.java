package cn.joim.algorithm.array;

/**
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class JumpGames {


    public static void main(String[] args) {

        /**
         * {2,1,1,4}
         *
         *
         * {2,3,1,1,4}
         * */
        //int input[] = {2, 3, 1, 1, 4};

        /**
         * {3,0}
         * {3,1,0}
         *   {3,2,0}
         *   {3,2,1,0}
         * */
//        int input[] = {3, 2, 1, 0, 4};
//        int input[] = {2, 0, 0};
        int input[] = {3, 0, 0, 0};
        boolean result = new JumpGames().canJump(input);
        System.out.println("result : " + result);
    }

    /**
     * public boolean canJump(int[] nums) {
     *
     *     }
     *
     *
     * */

    /**
     * 首先，如果除了最后一个item外都是正整数，则 true;
     * 如果其中一个item（i）为0，判断是否能跳过这个item，比如
     * (i-1)>1/(i-2)>2/(i-3)>3/.../i-i+1> i-1,则true.
     */
    public boolean canJump(int arr[]) {
        if (arr == null) {
            return false;
        } else if (arr.length <= 1) {
            return true;
        }
        boolean result = false;

        //n次.

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0) {

                result = true;
            } else {
                result = false;
                break;
            }
        }
        if (!result) {
            //说明至少有1哥 item为0.
            for (int i = 0; i < arr.length - 1; i++) {
                //step 1. 找到item为0的位置.
                if (arr[i] == 0) {
                    //step 2. 能跳过这个0吗
                    if (!canJump(arr, 0, i)) {
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
                }
            }


        }


        return result;
    }


    /**
     * //int input[] = {3, 2, 2, 0, 4};
     * 0, 1, 2, 3, 4
     * <p>
     * to = 3
     */
    private static boolean canJump(int arr[], int from, int to) {
        boolean canJump = false;
        for (int i = from; i < to; i++) {
            if (arr[i] > to - i) {
                canJump = true;
                break;
            }
        }
        return canJump;
    }
}
