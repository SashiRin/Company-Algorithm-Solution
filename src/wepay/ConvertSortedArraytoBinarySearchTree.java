package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : ConvertSortedArraytoBinarySearchTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        TreeNode root=helper(nums,0,nums.length-1);
        return root;
    }
    private TreeNode helper(int[] nums,int min,int max){
        if(min>max) return null;
        int mid=(min+max)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=helper(nums,min,mid-1);
        node.right=helper(nums,mid+1,max);
        return node;
    }

}
