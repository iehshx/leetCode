import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public void backtrack(List<java.lang.String> res, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append('(');
            backtrack(res, cur, left + 1, right, max);
//            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(')');
            backtrack(res, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public void process(List<String> res, StringBuilder path, int pair) {
        System.out.println(path.length());
        if (path.length() == pair * 2) {
            res.add(path.toString());
            return;
        } else {

            //当前生成(
            path.append("(");
            process(res, path, pair);
//            path.deleteCharAt(path.length() - 1);
            //当前生成右)
            path.append(")");
            process(res, path, pair);
//            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = new Solution().generateParenthesis(2);
        List<String> ans2 = new ArrayList<>();
        new Solution().process(ans2, new StringBuilder(), 2);
        for (String item :
                ans) {
            System.out.println(item);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        for (String item :
                ans2) {
            System.out.println(item);
        }


    }
}