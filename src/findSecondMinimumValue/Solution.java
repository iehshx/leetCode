package findSecondMinimumValue;

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

    int first = Integer.MIN_VALUE;
    int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null || root.left == null || root.right == null) {
            return -1;
        }
        first = root.val;
        process(root);
        return ans == first ? -1 : ans;
    }

    private void process(TreeNode root) {
        if (root == null) return;
        first = Math.min(first, root.val);//得到当前最小节点
        if (root.val > first) {
            //当前节点大于最小节点
            if (root.val < ans) {//当前节点又比第二小的节点小  第二小的被替换
                ans = root.val;
            } else if (ans == -1) {
                ans = root.val;
            }
        }
        process(root.left);
        process(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println(new Solution().findSecondMinimumValue(root));
    }

}