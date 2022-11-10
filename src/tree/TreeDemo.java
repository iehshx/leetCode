package tree;

public class TreeDemo {
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

    public static void main(String[] args) {
        TreeNode right5 = new TreeNode(5);
        TreeNode left2 = new TreeNode(2, null, right5);
        TreeNode right4 = new TreeNode(4);
        TreeNode right3 = new TreeNode(3, null, right4);
        TreeNode root = new TreeNode(1, left2, right3);
        test1(root);
    }

    private static void test1(TreeNode root) {
        if (root == null) return;
        test1(root.left);
        test1(root.right);
        System.out.println(root.val);
    }
}
