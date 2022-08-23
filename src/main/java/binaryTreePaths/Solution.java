package binaryTreePaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        process(root, new LinkedList<>(), ans);
        return ans;
    }

    private void process(TreeNode root, LinkedList<Integer> items, List<String> ans) {
        if (root == null) {
            return;
        }
        items.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(buildAns(items));
        }
        process(root.left, items, ans);
        process(root.right, items, ans);
        items.pollLast();
    }

    private String buildAns(LinkedList<Integer> items) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < items.size(); i++) {
            sb.append(items.get(i) + "->");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public static void main(String[] args) {

        TreeNode right5 = new TreeNode(5);
        TreeNode left2 = new TreeNode(2, null, right5);
        TreeNode right3 = new TreeNode(3);
        TreeNode root1 = new TreeNode(1, left2, right3);

        List<String> ans = new Solution().binaryTreePaths(root1);
        System.out.println("1");

    }
}