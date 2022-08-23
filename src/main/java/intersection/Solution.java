package intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return nums1;
        }
        if (nums2 == null || nums2.length == 0) {
            return nums2;
        }
        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            map.add(nums1[i]);
        }

        int ans[] = new int[Math.min(nums1.length, nums2.length)];
        int size = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (map.contains(nums2[i])) {
                ans[size++] = nums2[i];
                map.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(ans, 0, size);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] ans = intersection(nums1, nums2);
        for (int item : ans) {
            System.out.println(item);
        }
    }
}