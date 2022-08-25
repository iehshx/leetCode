package increasingBST;


import java.util.ArrayList;
import java.util.List;

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
    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> ans = new ArrayList<>();
        process(root, ans);
        return generateTree(ans);
    }

    private TreeNode generateTree(List<Integer> ans) {
        TreeNode root = new TreeNode(ans.get(0));
        TreeNode temp = root;
        for (int i = 1; i < ans.size(); i++) {
            temp.left = null;
            temp.right = new TreeNode(ans.get(i));
            temp = temp.right;
        }
        return root;
    }

    private void process(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        process(root.left, nodes);
        nodes.add(root.val);
        process(root.right, nodes);
    }


    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2, left1, null);
        TreeNode right4 = new TreeNode(4);
        TreeNode left3 = new TreeNode(3, left2, right4);
        TreeNode right8 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode right6 = new TreeNode(6, null, right8);
        TreeNode root = new TreeNode(5, left3, right6);
        TreeNode newRoot = new Solution().increasingBST(root);
        printTree(newRoot);
    }

    private static void printTree(TreeNode newRoot) {
        if (newRoot == null)
            return;
        System.out.println(newRoot.val);
        printTree(newRoot.left);
        printTree(newRoot.right);
    }

}