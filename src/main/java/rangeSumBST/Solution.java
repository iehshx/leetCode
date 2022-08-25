package rangeSumBST;

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
    int ans = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        process(root, low, high);
        return ans;
    }

    private void process(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val >= low && root.val <= high) {
            ans += root.val;
        }
        process(root.left, low, high);
        process(root.right, low, high);
    }

}