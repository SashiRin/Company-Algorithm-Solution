package indeed;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : TreeRootToLeafMinCostPath
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class TreeRootToLeafMinCostPath {
    /*
    找一个树根到叶子的min cost path
     */
    private static List<Integer> res = new ArrayList<>();
    private static int cost = Integer.MAX_VALUE;
    private static String s = "";

    public static List<Integer> minCostPath(TreeNode root) {
        if (root == null) return res;
        helper(root, new ArrayList<>(), 0,"");
        return res;
    }
    public static void helper(TreeNode root, List<Integer> list, int sum, String path) {
        if (sum > cost || root == null) return;
        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum < cost) {
                cost = sum;
                res = new ArrayList<>(list);
                s = path + root.val;
            }
        }
        helper(root.left, list, sum, path + root.val + "->");
        helper(root.right, list, sum, path + root.val + "->");
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> ret = minCostPath(root);
        for (int num : ret) {
            System.out.println(num);
        }
        System.out.println(s);
    }
}
