package merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length < 2) {
            return new int[0][0];
        }
        int n = intervals.length;
        if (n == 1){
            return intervals;
        }
        Node[] ranges = new Node[n];
        for (int i = 0; i < n; i++) {
            ranges[i] = new Node(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(ranges, (o1, o2) -> o1.start - o2.start);
        ArrayList<Node> ans = new ArrayList<>();
        int s = ranges[0].start;
        int e = ranges[0].end;
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i].start > e) {
                ans.add(new Node(s, e));
                s = ranges[i].start;
                e = ranges[i].end;
            } else {
                e = Math.max(e, ranges[i].end);
            }
        }
        ans.add(new Node(s, e));
        int[][] ret = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ret[i][0] = ans.get(i).start;
            ret[i][1] = ans.get(i).end;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = new Solution().merge(intervals);
    }
}