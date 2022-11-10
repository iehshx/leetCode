package isSymmetric;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


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

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return process(root, root);
    }

    private boolean process(TreeNode node, TreeNode node2) {
        if (node == null && node2 == null) {
            return true;
        }
        if (node == null || node2 == null) {
            return false;
        }
        return node.val == node2.val && process(node.left, node2.right) && process(node2.right, node.left);
    }

    public static void main(String[] args) {
//        [1,2,2,3,4,4,3]

        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(new Solution().isSymmetric(root));
    }
}