//package sumRootToLeaf;
//
//
//class Solution {
//
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public int sumRootToLeaf(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return process(root).value;
//    }
//
//    class Info {
//        int value;
//        int leftLevel;
//        int rightLevel;
//
//        Info(int v, int l, int r) {
//            this.value = v;
//            this.leftLevel = l;
//            this.rightLevel = r;
//        }
//    }
//
//    private Info process(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//
//        int value = 0;
//        Info leftInfo = process(root.left);
//        if (leftInfo != null) {
//
//        }
//
//        Info rightInfo = process(root.right);
//
//        return new Info(value, leftInfo.level + 1);
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)));
//        System.out.println(new Solution().sumRootToLeaf(root));
//    }
//
//}