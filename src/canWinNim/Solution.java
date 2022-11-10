package canWinNim;

class Solution {
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        return process(n);
    }

    private boolean process(int n) {
        if (n <= 3) {
            return true;
        }
        boolean p1 = process(n - 3);
        boolean p2 = process(n - 2);
        boolean p3 = process(n - 1);
        return !(p1 && p2 && p3);
    }

    /**
     * 你和你的朋友，两个人一起玩 Nim 游戏：
     * <p>
     * <p>
     * 桌子上有一堆石头。
     * 你们轮流进行自己的回合， 你作为先手 。
     * 每一回合，轮到的人拿掉 1 - 3 块石头。
     * 拿掉最后一块石头的人就是获胜者。
     * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。如果可以赢，返回 true；否则，返回 false 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 11;
//        n^n
        for (int i = 0; i < 36; i++) {
            if (new Solution().canWinNim(i) == false){
                System.out.println(i);
            }
        }
    }
}