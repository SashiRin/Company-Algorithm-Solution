package indeed;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : TreeParent
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class TreeParent {
    //BFS找出parents

    public static TreeNode searchParent(TreeNode root, TreeNode child) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == child || cur.right == child) {
                return cur;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return null;
    }
}
