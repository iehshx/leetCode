package intersect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> map = new ArrayList<>();
        int[] longArr = nums1.length > nums2.length ? nums1 : nums2;
        int[] shortArr = longArr == nums1 ? nums2 : nums1;
        for (int i = 0; i < longArr.length; i++) {
            map.add(longArr[i]);
        }

        int ans[] = new int[shortArr.length];
        int size = 0;
        for (int i = 0; i < shortArr.length; i++) {
            if (size == shortArr.length) {
                break;
            }
            if (map.contains(shortArr[i])) {
                ans[size++] = shortArr[i];
                map.remove(shortArr[i]);
            }
        }
        return Arrays.copyOfRange(ans, 0, size);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int ans[] = new Solution().intersect(nums1, nums2);
        for (int item :
                ans) {
            System.out.println(item);
        }
    }
}