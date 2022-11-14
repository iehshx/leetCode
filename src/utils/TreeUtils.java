package utils;

public class TreeUtils {


    public static TreeNode sortedArrayToBST(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return null;
        }
        int L = 0;
        int R = N;
        int mid = L + (R - L) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, L, mid);
        root.right = process(nums, mid + 1, N);
        return root;
    }


    TreeNode process(Integer nums[], int i) {
        if (i >= nums.length) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = nums[i];
        node.left = i + 1 < nums.length ? nums[i + 1] != null ? new TreeNode(nums[i + 1]) : null : null;
        node.right = i + 2 < nums.length ? nums[i + 2] != null ? new TreeNode(nums[i + 2]) : null : null;
        return node;
    }


    private static TreeNode process(int[] nums, int l, int r) {
        if (l == r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, l, mid);
        root.right = process(nums, mid + 1, r);
        return root;
    }
}
