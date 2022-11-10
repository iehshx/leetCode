package getTargetCopy;


class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) {
            return null;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        TreeNode ret = null;
        if (left != null) {
            ret = left;
        }
        if (right != null) {
            ret = right;
        }
        if (left != null || right != null) {
            return ret;
        } else {
            return original.val == target.val ? original : null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
        System.out.println(new Solution().getTargetCopy(root, root, new TreeNode(1)).val);

    }
}