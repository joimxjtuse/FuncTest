package cn.joim.algorithm.tree;


/**
 * 654. 最大二叉树
 * <p>
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode result = new ConstructMaximumBinaryTree()
                .constructMaximumBinaryTree(nums);
        System.out.println("ok.");

    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        TreeNode head = createFrom(nums, 0, nums.length - 1);

        return head;

        /**
         * 1. 找到最大值下标max;
         * 2. 构造左侧树；
         * 3.构造右侧树.
         * */
       /* int maxPosition = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[maxPosition] < nums[i]) {
                maxPosition = i;
            }
        }
        head = new TreeNode(nums[maxPosition]);
        if (maxPosition >= 0) {
            head.left = createFrom(nums, 0, maxPosition - 1);
        }

        if (maxPosition < nums.length - 1) {
            head.right = createFrom(nums, maxPosition + 1,
                    nums.length - 1);
        }


        return head;*/
    }


    private TreeNode createFrom(int[] nums, int nStart, int nEnd) {
        TreeNode head = null;
        if (nStart == nEnd) {
            head = new TreeNode(nums[nStart]);
        } else {
            int maxPosition = nStart;
            for (int i = nStart; i <= nEnd; i++) {
                if (nums[maxPosition] < nums[i]) {
                    maxPosition = i;
                }
            }

            head = new TreeNode(nums[maxPosition]);
            if (maxPosition > nStart) {
                head.left = createFrom(nums, nStart, maxPosition - 1);
            }

            if (maxPosition < nEnd) {
                head.right = createFrom(nums, maxPosition + 1,
                        nEnd);
            }
        }
        return head;
    }
}
