package findMode;

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

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] findMode(TreeNode root) {
        process(root);
        int maxCount = 0;
        for (int value : map.values()) {
            maxCount = Math.max(maxCount, value);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == maxCount) {
                ret.add(item.getKey());
            }
        }
        int[] ans = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

    private void process(TreeNode root) {
        if (root == null) return;
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }
        process(root.left);
        process(root.right);

    }

    public static void main(String[] args) {
//        [1,null,2,2]
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(2), null));
        System.out.println(new Solution().findMode(root)[0]);
    }
}