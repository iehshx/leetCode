package isCousins;

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

class TreeNode {
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

class Solution {

    TreeNode xParent;
    int xDepth;
    boolean xFound;

    TreeNode yParent;
    int yDepth;
    boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        process(root, x, y, 0, null);
        return xDepth == yDepth && xParent != yParent;
    }

    private void process(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xFound = true;
            xDepth = depth;
            xParent = parent;
        }
        if (root.val == y) {
            yFound = true;
            yDepth = depth;
            yParent = parent;
        }
        if (xFound && yFound) return;
        process(root.left, x, y, depth + 1, root);
        if (xFound && yFound) return;
        process(root.right, x, y, depth + 1, root);
    }

    public static void main(String[] args) {
//        [1,2,3,4]
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        System.out.println(new Solution().isCousins(root, 3, 4));
    }
}