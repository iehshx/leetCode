package deepestLeavesSum;

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

class Info {
    int maxDeepValue;
    int maxLevel;

    public Info() {
    }

    public Info(int maxDeepValue) {
        this.maxDeepValue = maxDeepValue;
    }

    public Info(int maxDeepValue, int level) {
        this.maxDeepValue = maxDeepValue;
        this.maxLevel = level;
    }
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root, 0).maxDeepValue;
//        return process(root).maxDeep;
    }

    class MaxDeepInfo {
        int maxDeep;

        public MaxDeepInfo(int maxDeep) {
            this.maxDeep = maxDeep;
        }
    }

    MaxDeepInfo process(TreeNode root) {
        if (root == null) {
            return new MaxDeepInfo(0);
        }
        MaxDeepInfo leftInfo = process(root.left);
        MaxDeepInfo rightInfo = process(root.right);
        if (leftInfo.maxDeep > rightInfo.maxDeep) {
            System.out.println(root.val);
        }
        return new MaxDeepInfo(Math.max(leftInfo.maxDeep, rightInfo.maxDeep) + 1);
    }


//    int maxDeep() {
//
//    }

    private Info process(TreeNode root, int level) {
        if (root == null) {
            return new Info(0, level);
        }
        Info leftInfo = process(root.left, level + 1);
        Info rightInfo = process(root.right, level + 1);
        Info ret = new Info();
//        if (level > leftInfo.maxLevel) {
//            ret.maxLevel = level;
//            ret.maxDeepValue = root.val;
//            ret.maxDeepValue = root.val + leftInfo.maxDeepValue;
//        } else if(level == ) {
//            ret.maxDeepValue = root.val + leftInfo.maxDeepValue + rightInfo.maxDeepValue;
//        }
//        ret.maxLevel = Math.max(Math.max(leftInfo.maxLevel, level), rightInfo.maxLevel);
        return ret;
    }

    public static void main(String[] args) {
//        TreeNode left7 = new TreeNode(7);
//        TreeNode left4 = new TreeNode(4, left7, null);
//        TreeNode right5 = new TreeNode(5);
//        TreeNode left2 = new TreeNode(2, left4, right5);
//        TreeNode right8 = new TreeNode(8);
//        TreeNode right6 = new TreeNode(6, null, right8);
//        TreeNode right3 = new TreeNode(3, null, right6);
//        TreeNode root = new TreeNode(1, left2, right3);


        TreeNode left9 = new TreeNode(9);
        TreeNode left2 = new TreeNode(2, left9, null);
        TreeNode left1 = new TreeNode(1);
        TreeNode right4 = new TreeNode(4);
        TreeNode right7 = new TreeNode(7, left1, right4);
        TreeNode left7 = new TreeNode(7, left2, right7);
        TreeNode left1_1 = new TreeNode(1);
        TreeNode right5 = new TreeNode(5);
        TreeNode right3 = new TreeNode(3, null, right5);
        TreeNode right8 = new TreeNode(8, left1_1, right3);
        TreeNode root = new TreeNode(6, left7, right8);
        System.out.println(new Solution().deepestLeavesSum(root));
    }
}