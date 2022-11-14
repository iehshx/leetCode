package isBalanced;

import utils.TreeUtils;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Info {
        boolean isBlanced = false;
        int height = 0;

        public Info(boolean isBlanced, int height) {
            this.isBlanced = isBlanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return process(root).isBlanced;
    }

    private Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        int height = 0;
        boolean isBalanced = false;
        isBalanced = leftInfo.isBlanced && rightInfo.isBlanced && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(isBalanced, height);
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
//        TreeUtils.TreeNode root = TreeUtils.createBinaryTree(nums);
//        System.out.println(root.val);
    }
}