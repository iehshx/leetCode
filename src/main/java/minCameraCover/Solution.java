package minCameraCover;


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

    class Info {
        long unconvered;//x没有覆盖，x为头的树至少需要几个相机
        long converedNoCamera;//x被相机覆盖，但是x没相机，x为头的树至少需要几个相机
        long converedHasCamera;//x被相机覆盖，并且x有相机，x为头的树需要几个相机

        public Info(long unconvered, long converedNoCamera, long converedHasCamera) {
            this.unconvered = unconvered;
            this.converedNoCamera = converedNoCamera;
            this.converedHasCamera = converedHasCamera;
        }
    }

    public int minCameraCover(TreeNode root) {
        Info ret = process(root);
        return (int) Math.min(ret.unconvered + 1, Math.min(ret.converedHasCamera, ret.converedNoCamera));
    }

    private Info process(TreeNode node) {
        if (node == null) {//空树 认为被覆盖 不能放相机
            return new Info(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        //自己没有被覆盖，所以左孩子不能有相机，右孩子也不能有
        long unconvered = leftInfo.converedNoCamera + rightInfo.converedNoCamera;
        //被相机覆盖，但是我没有相机 所以左孩子和右孩子取最小
        long converedNoCamera = Math.min(leftInfo.converedHasCamera + rightInfo.converedHasCamera,//左右都有相机
                Math.min(leftInfo.converedHasCamera + rightInfo.converedNoCamera, //左有 右没有
                        leftInfo.converedNoCamera + rightInfo.converedHasCamera//右边有左边没有
                ));
        //x被相机覆盖，并且x有相机，x为头的树需要几个相机
        long converedHasCamera = Math.min(leftInfo.unconvered, Math.min(leftInfo.converedNoCamera, leftInfo.converedHasCamera))
                + Math.min(rightInfo.unconvered, Math.min(rightInfo.converedNoCamera, rightInfo.converedHasCamera))
                + 1;
        return new Info(unconvered, converedNoCamera, converedHasCamera);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(), new TreeNode()), null);
        TreeNode root = new TreeNode(0, new TreeNode(0, new TreeNode(0, new TreeNode(0, null, new TreeNode()), null), null), null);
        System.out.println("args = " + new Solution().minCameraCover(root));
    }
}