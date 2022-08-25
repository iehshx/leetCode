package minDiffInBST;

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
    int ans = Integer.MAX_VALUE;
    int pre = -1;

    public int minDiffInBST(TreeNode root) {
        process(root);
        return ans;
    }

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, Math.abs(pre - root.val));
            pre = root.val;
        }
        process(root.right);
    }

    public static void main(String[] args) {

        int a = 3;
        test(a);
        System.out.println(a);
    }

    private static void test(int a) {
        a = 10;
    }
}