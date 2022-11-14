package kthLargest;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

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

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        List<Integer> nums = new ArrayList<>();
        process(root, nums);
        return nums.get(nums.size() - k);

    }

    private void process(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        process(root.left, nums);
        nums.add(root.val);
        process(root.right, nums);
    }


    public static void main(String[] args) {
//        [3,1,4,null,2]
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(new Solution().kthLargest(root, 1));
    }
}