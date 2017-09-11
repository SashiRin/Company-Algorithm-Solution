package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : ValidateBinarySearchTree
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        if (max != null && root.val >= max) return false;
        if (min != null && root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
