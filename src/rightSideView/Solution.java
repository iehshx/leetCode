package rightSideView;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.get(queue.size() - 1).val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        TreeNode right5 = new TreeNode(5);
        TreeNode left2 = new TreeNode(2, null, right5);
        TreeNode right4 = new TreeNode(4);
        TreeNode right3 = new TreeNode(3, null, right4);
        TreeNode root = new TreeNode(1, left2, right3);
        List<Integer> ans = new Solution().rightSideView(root);
        for (Integer item : ans) {
            System.out.println(item);
        }
    }
}