package sortedArrayToBST;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        int N = nums.length;
        int L = 0;
        int R = N;
        int mid = L + (R - L) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, L, mid);
        root.right = process(nums, mid + 1, N);
        return root;
    }

    private TreeNode process(int[] nums, int l, int r) {
        if (l == r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, l, mid);
        root.right = process(nums, mid + 1, r);
        return root;
    }

    static void printTree(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }


    public static void main(String[] args) {
        int nums[] = {-10, -3, 0, 5, 9};
        TreeNode root = new Solution().sortedArrayToBST(nums);
        printTree(root);

    }

}