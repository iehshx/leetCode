//package canPartitionKSubsets;
//
//class Solution {
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || nums.length < k) return false;
//        return process(nums, 0, nums.length, k);
//    }
//
//    /**
//     * 从nums i 到j是否可以搞出来target为k
//     *
//     * @param nums
//     * @param i
//     * @param j
//     * @param target
//     * @return
//     */
//    private boolean process(int[] nums, int i, int j, int target) {
//        if (j <= i) {
//            return false;
//        }
//        //不要当前i位置的数字
//        boolean p1 = process(nums, i, j - 1, target);
//        //要当前i位置的数字
//        boolean p2 = process(nums,i,j);
//        return false;
//    }
//
//    public static void main(String[] args) {
////        int[] nums = {4, 3, 2, 3, 5, 2, 1};
//        int[] nums = {1,2,3,4};
//        int k = 3;
//        System.out.println(new Solution().canPartitionKSubsets(nums, k));
//    }
//}