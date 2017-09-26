package indeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : BinaryTreePaths
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class BinaryTreePaths {
    /**
     * Given a binary tree, return all root-to-leaf paths.

     For example, given the following binary tree:

     1
     /   \
     2     3
     \
     5
     All root-to-leaf paths are:

     ["1->2->5", "1->3"]
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, "");
        return res;
    }

    public static void helper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            helper(res, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, path + root.val + "->");
        }

    }
}
