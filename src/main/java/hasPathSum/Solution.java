package hasPathSum;

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


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val) || (targetSum - root.val == 0 && root.left == null && root.right == null);
    }

    public static void main(String[] args) {
        TreeNode left7 = new TreeNode(7);
        TreeNode right2 = new TreeNode(2);
        TreeNode left11 = new TreeNode(11, left7, right2);
        TreeNode left4 = new TreeNode(4, left11, null);
        TreeNode left13 = new TreeNode(13);
        TreeNode right1 = new TreeNode(1);
        TreeNode right4 = new TreeNode(4, null, right1);
        TreeNode right8 = new TreeNode(8, left13, right4);
        TreeNode root5 = new TreeNode(5, left4, right8);
//        TreeNode left2 = new TreeNode(2);
//        TreeNode root1 = new TreeNode(1, left2, null);
        System.out.println(new Solution().hasPathSum(root5, 22));
    }
}