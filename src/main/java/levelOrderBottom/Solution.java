package levelOrderBottom;

import java.util.*;

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> items = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                items.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            stack.push(items);
        }

        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode left9 = new TreeNode(9);
        TreeNode left15 = new TreeNode(15);
        TreeNode right7 = new TreeNode(7);
        TreeNode right20 = new TreeNode(20, left15, right7);
        TreeNode root3 = new TreeNode(3, left9, right20);
        List<List<Integer>> ans = new Solution().levelOrderBottom(root3);
        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
        System.out.println(1);
    }
}