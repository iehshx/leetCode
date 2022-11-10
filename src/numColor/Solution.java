package numColor;

import java.util.HashMap;
import java.util.HashSet;

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

    //    [1,3,2,1,null,2]
    int types = 0;

    public int numColor(TreeNode root) {
        if (root == null) {
            return 0;
        }
        HashSet<Integer> map = new HashSet<>();
        process(root, map);
        return types;
    }

    private void process(TreeNode root, HashSet<Integer> map) {

        if (root == null) return;
        if (!map.contains(root.val)) {
            types++;
            map.add(root.val);
        }
        process(root.left, map);
        process(root.right, map);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(1), null), new TreeNode(2, new TreeNode(2), null));
        System.out.println(new Solution().numColor(root));
    }
}