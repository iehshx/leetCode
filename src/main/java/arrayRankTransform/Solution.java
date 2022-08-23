package arrayRankTransform;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int[] ans = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int index = map.get(arr[i]);
            ans[index] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        int[] ans = new Solution().arrayRankTransform(arr);
        for (int item : ans) {
            System.out.println(item);
        }
    }
}