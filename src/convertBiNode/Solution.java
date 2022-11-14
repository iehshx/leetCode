package convertBiNode;

import utils.TreeNode;

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
    public TreeNode convertBiNode(TreeNode root) {

        if (root == null) return null;
        TreeNode ans = new TreeNode();
        pre = ans;
        process(root);
        return ans.right;
    }

    TreeNode pre;

    private void process(TreeNode root) {
        if (root == null) {
            return;
        }
        process(root.left);
        if (pre != null) {
            pre.right = root;
            root.left = null;
            pre = root;
        }
        process(root.right);
    }

    public static void main(String[] args) {
//        输入： [4,2,5,1,3,null,6,0]
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, new TreeNode(0), null), new TreeNode(3)), new TreeNode(5, null, new TreeNode(6)));

        System.out.println(new Solution().convertBiNode(root).val);
    }
}