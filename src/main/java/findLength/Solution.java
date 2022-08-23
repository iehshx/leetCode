package findLength;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0;

        return process(nums1, nums2, nums1.length - 1, nums2.length - 1, 0);

    }

    private int process(int[] nums1, int[] nums2, int i, int j, int ans) {
        if (i >= nums1.length || j >= nums2.length) return 0;
//        if (i == 0 && j == 0) {
//            return nums1[i] == nums2[j] ? 1 : 0;
//        }
//        if (i == 0) {
//            if (nums1[i] == nums2[j]) {
//                return 1;
//            } else {
//                return process(nums1, nums2, i, j - 1);
//            }
//        }else  if (j == 0) {
//            if (nums1[i] == nums2[j]) {
//                return 1;
//            } else {
//                return process(nums1, nums2, i - 1, j);
//            }
//        } else {
        int p3 = nums1[i--] == nums2[j--] ? (1 + process(nums1, nums2, i + 1, j + 1, ans)) : 0;
        ans = Math.max(ans, p3);
        return ans;
//        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 0, 1};
        System.out.println(new Solution().findLength(nums1, nums2));
    }
}