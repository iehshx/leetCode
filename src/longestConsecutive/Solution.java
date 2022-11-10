package longestConsecutive;

import java.util.HashMap;
import java.util.HashSet;

class Solution {


    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> header = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> tail = new HashMap<Integer, Integer>();
        HashSet<Integer> visited = new HashSet<>();//重复数字
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                visited.add(nums[i]);
                header.put(nums[i], 1);
                tail.put(nums[i], 1);
                if (tail.containsKey(nums[i] - 1)) {//先在尾表看有没有99的
                    int preLen = tail.get(nums[i] - 1);//获取99的长度
                    int preHead = nums[i] - preLen;//修改头表的数据
                    header.put(preHead, preLen + 1);
                    tail.put(nums[i], preLen + 1);
                    tail.remove(nums[i] - 1);
                    header.remove(nums[i]);//头表如果有99 删除掉
                }
                if (header.containsKey(nums[i] + 1)) {//再头表看有没有101
                    int preLen = tail.get(nums[i]);
                    int preHead = nums[i] - preLen + 1;//看看之前的头表
                    int postLen = header.get(nums[i] + 1);//获取到101的长度
                    int postTail = nums[i] + postLen;//更新尾表
                    header.put(preHead, preLen + postLen);
                    tail.put(postTail, preLen + postLen);
                    header.remove(nums[i] + 1);
                    tail.remove(nums[i]);
                }
            }
        }
        int ans = 0;
        for (int len : header.values()) {
            ans = Math.max(ans, len);
        }
        return ans;
    }


    /**
     * 题目六十六：给一个无序数组，返回可以组成的最长递增数组的长度。例如:[100,4,200,1,3,2] 返回4  {1,2,3,4} 返回4。
     * [0,3,7,2,5,8,4,6,0,1] 返回9
     * 当数据进来的时候 例如100  先在尾表看有没有99的、再头表看有没有101
     * 开头的没有 进入尾表  101的长度是1 ，然后进入3 同上 3的长度是1，接着进入4看尾表有没有3
     * 有 所以4的尾表长度是2  表示3..4 . 3的结尾信息删除 ，4的开头信息删除（头表不需要记录4开头的了）3的头表长度+1 表示3…4。
     */

    /**
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * @param args
     */
    public static void main(String[] args) {

        int nums[] = {100, 4, 200, 1, 3, 2};
        System.out.println(new Solution().longestConsecutive(nums));
    }
}