//package permuteUnique;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//class Solution {
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(nums);
//        boolean[] used = new boolean[nums.length];
//        process(nums, used, new ArrayList<>(), ans);
//        return ans;
//    }
//
//    private void process(int[] nums, boolean used[], List<Integer> path, List<List<Integer>> ans) {
//        if (path.size() == nums.length) {
//            //收集答案
//            ans.add(new ArrayList<>(path));
//        } else {
//            for (int j = 0; j < nums.length; j++) {
//                if (j > 0 && nums[j] == nums[j - 1] && used[j - 1] == false) {
//                    continue;
//                }
//                if (!used[j]) {
//                    used[j] = true;
//                    path.add(nums[j]);
//                    process(nums, used, path, ans);
//                    path.remove(path.size() - 1);
//                    used[j] = false;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] nums = {1, 2, 1};
//        List<List<Integer>> ans = new Solution().permuteUnique(nums);
//        for (List<Integer> items : ans) {
//            for (Integer item : items) {
//                System.out.print(item);
//            }
//            System.out.println();
//        }
//    }
//}