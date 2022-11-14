package findTilt;

import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {


    int ans = 0;


    public int findTilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        process(root);
        return ans;
    }

    private int process(TreeNode root) {
        if (root == null) return 0;
        int leftValue = process(root.left);
        int rightValue = process(root.right);
        ans += Math.abs(leftValue - rightValue);
        return leftValue + rightValue + root.val;
    }


    public static void main(String[] args) {
//        [4,2,9,3,5,null,7]
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)));
        System.out.println(new Solution().findTilt(root));
    }


}