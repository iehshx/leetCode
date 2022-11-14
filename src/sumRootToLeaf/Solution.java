package sumRootToLeaf;


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


    int ans = 0;


    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        process(root, 0);
        return ans;
    }

    private void process(TreeNode root, int value) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            value <<= 1;
            value |= root.val;
            ans += value;
        } else {
            value <<= 1;
            value |= root.val;
            process(root.left, value);
            process(root.right, value);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(1), null);
        System.out.println(new Solution().sumRootToLeaf(root));
    }

}