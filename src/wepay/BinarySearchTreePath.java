package wepay;

import java.util.ArrayList;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : BinarySearchTreePath
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class BinarySearchTreePath {
    public static ArrayList<Integer> printPath(TreeNode node, ArrayList<Integer> path, int value) {
        if (node == null) {
            return path;
        }
        path.add(node.val);
        if (node.val < value) {
            printPath(node.right, path, value);
        } else if(node.val>value){
            printPath(node.left, path, value);
        }
        return path;
    }
}
