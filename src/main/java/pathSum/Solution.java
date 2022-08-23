package pathSum;

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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            if (root.val - targetSum == 0) {
                ArrayList<Integer> items = new ArrayList<>();
                items.add(root.val);
                ans.add(items);
            }
            return ans;
        }
        process(root, targetSum, new LinkedList<>(), ans);
        return ans;
    }

    static class Info {
        int pathVal;
        boolean isPath;
        Info next;

        public Info(int pathVal, boolean isPath) {
            this.pathVal = pathVal;
            this.isPath = isPath;
        }
    }

    private Info process(TreeNode node, int targetSum, LinkedList<Integer> items, List<List<Integer>> ans) {
        if (node == null) {
            return null;
        }
        boolean isPath = false;
        int pathValue = node.val;
        items.add(pathValue);
        Info leftInfo = process(node.left, targetSum - node.val, items, ans);
        Info rightInfo = process(node.right, targetSum - node.val, items, ans);
        Info ret = new Info(pathValue, isPath);
        if (leftInfo != null) {
            isPath |= leftInfo.isPath;
        }
        if (rightInfo != null) {
            isPath |= rightInfo.isPath;
        }
        if (leftInfo == null && rightInfo == null) {
            isPath |= targetSum - node.val == 0 && node.left == null && node.right == null;
            if (isPath) {
                ans.add(copyList(items));
            }
        }
        ret.isPath = isPath;
        items.removeLast();
        return ret;
    }

    private List<Integer> copyList(List<Integer> items) {
        List<Integer> ret = new ArrayList<>();
        for (Integer item : items) {
            ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode left3_0 = new TreeNode(0);
        TreeNode right3_1 = new TreeNode(1);
        TreeNode left2_1 = new TreeNode(1, left3_0, right3_1);
        TreeNode left3__1 = new TreeNode(-1);
        TreeNode right3__0 = new TreeNode(0);
        TreeNode right2_2 = new TreeNode(2, left3__1, right3__0);
        TreeNode left1_0 = new TreeNode(0, left2_1, right2_2);
        TreeNode left3___1 = new TreeNode(-1);
        TreeNode right3___0 = new TreeNode(0);
        TreeNode left2_0 = new TreeNode(0, left3___1, right3___0);
        TreeNode left3_1 = new TreeNode(1);
        TreeNode right3_0 = new TreeNode(0);
        TreeNode right2__1 = new TreeNode(-1, left3_1, right3_0);
        TreeNode right1_1 = new TreeNode(1, left2_0, right2__1);
        TreeNode root1 = new TreeNode(1, left1_0, right1_1);

        List<List<Integer>> ans = new Solution().pathSum(root1, 2);
        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}