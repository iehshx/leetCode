package longestUnivaluePath;


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

    int ans = Integer.MIN_VALUE;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        ans = process(root);
        return ans - 1;
    }

    private int process(TreeNode root) {
        if (root == null)
            return 1;
        int leftValue = process(root.left);
        int rightValue = process(root.right);
        int value = leftValue + rightValue;
        boolean curValue = true;
        if (root.left != null) {
            curValue = root.val == root.left.val;
        }
        if (root.right != null) {
            curValue = root.val == root.right.val;
        }
        return curValue ? value + 2 : 0;
    }

    public static void main(String[] args) {
//        TreeNode right5 = new TreeNode(5, null, new TreeNode(5));
//        TreeNode left4 = new TreeNode(4, new TreeNode(1), new TreeNode(1));
//        TreeNode root = new TreeNode(5, left4, right5);
        TreeNode right5 = new TreeNode(5, null, new TreeNode(5));
        TreeNode left4 = new TreeNode(4, new TreeNode(4), new TreeNode(4));
        TreeNode root = new TreeNode(1, left4, right5);
        System.out.println(new Solution().longestUnivaluePath(root));
    }
}