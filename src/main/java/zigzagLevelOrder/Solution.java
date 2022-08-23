package zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> items = new ArrayList<>();
            if (ans.size() % 2 == 0) {
                for (int i = 0; i < queue.size(); i++) {
                    items.add(queue.get(i).val);
                }
            } else {
                for (int i = queue.size() - 1; i >= 0; i--) {
                    items.add(queue.get(i).val);
                }
            }

            for (int i = size - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(items);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode left4 = new TreeNode(3);
        TreeNode right8 = new TreeNode(4);
        TreeNode left9 = new TreeNode(9, left4, right8);
        TreeNode left15 = new TreeNode(15);
        TreeNode right7 = new TreeNode(7);
        TreeNode right20 = new TreeNode(20, left15, right7);
        TreeNode root3 = new TreeNode(3, left9, right20);

        System.out.println(1 % 2);
        List<List<Integer>> ans = new Solution().zigzagLevelOrder(root3);

        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}