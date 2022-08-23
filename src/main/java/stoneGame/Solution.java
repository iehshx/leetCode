package stoneGame;

class Solution {
    public boolean stoneGame(int[] piles) {
        if (piles.length == 2) {
            return true;
        }
        int alice = alice(piles, 0, piles.length - 1);
        int bob = bob(piles, 0, piles.length - 1);
        return alice > bob;
    }


    public boolean stoneGame2(int[] piles) {
        if (piles.length == 2) {
            return true;
        }
        int n = piles.length;
        int[][] aliceMap = new int[n][n];
        int[][] bobMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            aliceMap[i][i] = piles[i];
        }
        for (int i = 1; i < n; i++) {
            int l = 0;
            int r = i;
            while (r < n) {
                aliceMap[l][r] = Math.max(piles[l] + bobMap[l + 1][r], piles[r] + bobMap[l][r - 1]);
                bobMap[l][r] = Math.min(aliceMap[l + 1][r], aliceMap[l][r - 1]);
                l++;
                r++;
            }
        }
        return aliceMap[0][n - 1] > bobMap[0][n - 1];
    }

    private int alice(int[] piles, int i, int end) {
        if (i == end) {
            return piles[i];
        }
        int p1 = piles[i] + bob(piles, i + 1, end);
        int p2 = piles[end] + bob(piles, i, end - 1);
        return Math.max(p1, p2);
    }

    private int bob(int[] piles, int i, int end) {
        if (i == end) {
            return 0;
        }
        int p1 = alice(piles, i + 1, end);
        int p2 = alice(piles, i, end - 1);
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(new Solution().stoneGame(piles));
        System.out.println(new Solution().stoneGame2(piles));
    }

}