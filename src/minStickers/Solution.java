package minStickers;

import java.util.HashMap;

class Solution {


    int[] countChars(String target) {
        char[] strs = target.toCharArray();
        int[] counts = new int[26];
        for (int i = 0; i < strs.length; i++) {
            counts[strs[i] - 'a']++;
        }
        return counts;
    }

    public int minStickers(String[] stickers, String target) {
        int N = stickers.length;
        int[][] stickerChars = new int[N][];
        for (int i = 0; i < N; i++) {
            stickerChars[i] = countChars(stickers[i]);
        }

        HashMap<String, Integer> dp = new HashMap<>();
        int ans = process(stickerChars, target,dp);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }

    int process(int[][] stickers, String target, HashMap<String,Integer> dp) {
        if (dp.containsKey(target)){
            return dp.get(target);
        }
        int[] targetCounts = countChars(target);
        int ans = 0;
        int N = stickers.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] sticker = stickers[i];
            if (sticker[target.charAt(0) - 'a'] > 0) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (targetCounts[j] > 0) {
                        int nums = targetCounts[j] - sticker[j];
                        for (int k = 0; k < nums; k++) {
                            sb.append((char) (j + 'a'));
                        }
                    }
                }
                String rest = sb.toString();
                if (rest.isEmpty()){
                    return 1;
                }
                min = Math.min(min, process(stickers, rest,dp));
            }
        }
        ans = min + (min == Integer.MAX_VALUE ? 0 : 1);
        dp.put(target,ans);
        return ans;
    }




    public static void main(String[] args) {
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";

        System.out.println(new Solution().minStickers(stickers, target));
    }
}