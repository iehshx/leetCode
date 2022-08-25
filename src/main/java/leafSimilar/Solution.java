package leafSimilar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Ans = new ArrayList<>();
        List<Integer> root2Ans = new ArrayList<>();
        process(root1, root1Ans);
        process(root2, root2Ans);
        return isSame(root1Ans, root2Ans);
    }

    private boolean isSame(List<Integer> root1Ans, List<Integer> root2Ans) {
        if (root1Ans.size() != root2Ans.size()) {
            return false;
        }
        for (int i = 0; i < root1Ans.size(); i++) {
            if (root1Ans.get(i) != root2Ans.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void process(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
        }
        process(root.left, nodes);
        process(root.right, nodes);
    }

    public static void main(String[] args) {
        TreeNode right2 = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode left5 = new TreeNode(5, new TreeNode(6), right2);
        TreeNode right1 = new TreeNode(1, new TreeNode(9), new TreeNode(8));
        TreeNode root1 = new TreeNode(3, left5, right1);
        TreeNode root2Left5 = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        TreeNode root2Right2 = new TreeNode(2, new TreeNode(9), new TreeNode(8));
        TreeNode root2Right1 = new TreeNode(1, new TreeNode(4), root2Right2);
        TreeNode root2 = new TreeNode(3, root2Left5, root2Right1);
        System.out.println(new Solution().leafSimilar(root1, root2));
    }
}