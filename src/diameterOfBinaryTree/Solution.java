package diameterOfBinaryTree;

import sun.reflect.generics.tree.Tree;
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

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        process(root);
        return ans - 1;
    }

    private int process(TreeNode root) {
        if (root == null) return 0;

        int L = process(root.left);
        int R = process(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
//[1,2,3,4,5]
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}