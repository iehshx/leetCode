package letterCasePermutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] strs = s.toCharArray();
        process(strs, 0, ans);
        return ans;
    }

    boolean isLetterCase(char s) {
        if (s >= 'a' && s <= 'z') return true;
        return false;
    }

    boolean isBigCase(char s) {
        if (s >= 'A' && s <= 'Z') return true;
        return false;
    }

    boolean isNumber(char s) {
        return s >= '0' && s <= '9';
    }

    private void process(char[] strs, int i, List<String> ans) {

        while (i < strs.length && isNumber(strs[i])) {
            i++;
        }
        if (i == strs.length) {
            ans.add(new String(strs));
            return;
        }
        //当前是字母
        if (isLetterCase(strs[i])) {
            strs[i] ^= 32;
            process(strs, i + 1, ans);
        } else if (isBigCase(strs[i])) {
            strs[i] ^= 32;
            process(strs, i + 1, ans);
        }
        strs[i] ^= 32;
        process(strs, i + 1, ans);
    }

    public static void main(String[] args) {
        String s = "3z4";
        List<String> ans = new Solution().letterCasePermutation(s);
        for (String item : ans) {
            System.out.println(item);
        }
    }
}