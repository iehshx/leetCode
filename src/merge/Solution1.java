package merge;

class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0, p3 = 0;
        int[] ans = new int[nums1.length];
        while (p1 < m && p2 < n) {
            ans[p3++] = nums1[p1] > nums2[p2] ? nums2[p2++] : nums1[p1++];
        }
        while (p1 < m) {
            ans[p3++] = nums1[p1++];
        }
        while (p2 < n) {
            ans[p3++] = nums2[p2++];
        }

        for (int i = 0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 0};
        int m = 1;
        int[] nums2 = {2};
        int n = 1;
        new Solution1().merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.println(num);
        }
    }
}