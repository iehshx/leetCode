package wordBreak;

import java.util.ArrayList;
import java.util.List;

class Solution {
    class Node {
        char cur;
        boolean end = false;
        Node[] nodes;

        public Node(char cur) {
            this.cur = cur;
            end = false;
            nodes = new Node[26];
        }
    }

    Node root = new Node(' ');

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < wordDict.size(); i++) {
            Node node = root;
            String word = wordDict.get(i);
            char[] chs = word.toCharArray();
            for (int j = 0; j < chs.length; j++) {
                int index = chs[j] - 'a';
                if (node.nodes[index] == null) {
                    node.nodes[index] = new Node(chs[j]);
                }
                node = node.nodes[index];
            }
            node.end = true;
        }
//        System.out.println(s.toCharArray().length);
        process(s.toCharArray(), 0, ans, "");
        return ans;
    }

    private void process(char[] chs, int i, List<String> ans, String path) {
//        System.out.println(i);
        if (i == 7) {
            //最后一个字符开头的了 收集答案
            ans.add(path);
            return;
        }
        Node node = root;
        for (int j = 0; j < chs.length; j++) {
            int index = chs[j] - 'a';
//            System.out.println(chs[j]);
            if (node.nodes[index] != null) {
                path += chs[j];
//                System.out.println(path);
                if (node.nodes[index].end) {
                    process(subArray(chs, j + 1, chs.length), i + j, ans, path);
                }
                node = node.nodes[index];
            } else {
//                System.out.println("没找到  path = " + path);
                path = "";
            }
        }

//        for (int j = i; j < wordDict.size(); j++) {
//            String item = wordDict.get(j);
//            wordDict.remove(i);
//            Node node = root;
//            for (int k = 0; k < item.length(); k++) {
//                int index = item.charAt(k) - 'a';
//                if (node.nodes[index] != null) {
//                    path += item.charAt(k);
//                    if (node.nodes[index].end) {
//                        process(chs, i + 1, wordDict, ans, path);
//                    }
//                    node = node.nodes[index];
//                } else {
//                    path = "";
//                }
//                wordDict.add(item);
//            }
    }


    private char[] subArray(char[] chs, int i, int j) {
        int len = j - i;
        char[] ret = new char[len];
        for (int k = 0; k < len; k++) {
            ret[k] = chs[i + k];
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> ans = new Solution().wordBreak(s, wordDict);
        for (String item : ans) {
            System.out.println(item);
        }
    }
}