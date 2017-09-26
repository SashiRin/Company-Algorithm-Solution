package indeed;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : TiltBinaryTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class TiltBinaryTree {
    /**
     * tilt ：给一棵binary tree。
     定义每个节点的tilt为其左边所有数的和与右边所有数的和的差值的绝对值，如果任意一边为null，定义为该节点的值为0。
     定义整棵树的tilt为所有node的tilt的和。
     求整棵树的tilt。

     follow up : 要去掉一个叶子，让总的tilt变得最小：
                greedy ： 没想出来
                不考虑时间复杂度: 挨个删掉叶子，检查删掉谁后的节点最小
     */

    private static int res = 0;

    public static int tilt(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    public static int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        res += Math.abs(l - r);
        return l + r + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);
        System.out.println(tilt(root));
    }
}
