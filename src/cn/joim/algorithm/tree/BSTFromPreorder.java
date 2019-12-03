package cn.joim.algorithm.tree;

/**
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 * <p>
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，
 * 值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示
 * 节点的值，然后遍历 node.left，接着遍历 node.right。）
 * <p>
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BSTFromPreorder {

    public static void main(String[] args) {


        int arrays[] = {8, 5, 1, 7, 10, 12};

        TreeNode result = new BSTFromPreorder().bstFromPreorder(arrays);
        System.out.println("ok.");

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode head = null;
        if (preorder != null && preorder.length > 0) {
            //head = new TreeNode(preorder[0]);

            /**
             * 每次都从根节点出发，找到最合适的位置.
             *
             * */

            for (int i = 0; i < preorder.length; i++) {
                TreeNode node = head;
                if (node == null) {
                    node = new TreeNode(preorder[i]);
                    head = node;
                } else {
                    //找到合适的节点.
                    TreeNode pre = null;
                    while (node != null) {
                        pre = node;
                        if (node.val >= preorder[i]) {
                            node = node.left;
                            if (node == null) {
                                TreeNode item = new TreeNode(preorder[i]);
                                pre.left = item;
                            }
                        } else {
                            node = node.right;
                            if (node == null) {
                                TreeNode item = new TreeNode(preorder[i]);
                                pre.right = item;
                            }
                        }
                    }
                }
            }


        }


        return head;
    }
}
