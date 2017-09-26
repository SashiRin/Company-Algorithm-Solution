package indeed;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : SubtreeofAnotherTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SubtreeofAnotherTree {
    /**
     * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

     Example 1:
     Given tree s:

     3
     / \
     4   5
     / \
     1   2
     Given tree t:
     4
     / \
     1   2
     Return true, because t has the same structure and node values with a subtree of s.

     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        String spreorder = generatepreorderString(s);
        String tpreorder = generatepreorderString(t);

        return spreorder.contains(tpreorder) ;
    }
    public String generatepreorderString(TreeNode s){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stacktree = new Stack();
        stacktree.push(s);
        while(!stacktree.isEmpty()){
            TreeNode cur = stacktree.pop();
            if(cur==null)
                sb.append(",#"); // Appending # inorder to handle same values but not subtree cases
            else
                sb.append(","+cur.val);
            if(cur!=null){
                stacktree.push(cur.right);
                stacktree.push(cur.left);
            }
        }
        return sb.toString();
    }
}
