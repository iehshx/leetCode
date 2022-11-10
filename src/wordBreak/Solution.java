package wordBreak;

import java.util.ArrayList;
import java.util.List;

class Solution {

    class Node {
        boolean end;
        Node[] nexts;

        int pass;

        Node() {
            pass = 0;
            end = false;
            nexts = new Node[26];
        }
    }


    public List<String> wordBreak(String s, List<String> wordDict) {

        Node root = new Node();
        for (int i = 0; i < wordDict.size(); i++) {
            char[] chs = wordDict.get(i).toCharArray();
            Node node = root;
            for (int j = 0; j < chs.length; j++) {
                int index = chs[j] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Node();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end = true;
        }

        List<String> ans = new ArrayList<String>();
        char[] chs = s.toCharArray();
        int N = chs.length;
       String path="";
        for (int i = 0; i < N; i++) {
            Node cur = root;
            for (int end = i; end < N; end++) {
                cur = cur.nexts[chs[end] - 'a'];
                if (cur == null) break;
                path+=chs[end];
                if (cur.end) {
                    path +=" ";
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "catsanddog";
        String[] wordDicts = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<String>();
        for (String item : wordDicts) {
            wordDict.add(item);
        }
        List<String> ans = new Solution().wordBreak(s, wordDict);
        for (String item : ans) {
            System.out.println(item);
        }
    }
}


