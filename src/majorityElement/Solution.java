package majorityElement;

class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0;
        int hp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hp == 0) {
                //无候选
                cand = nums[i];
                hp = 1;
            } else if (nums[i] == cand) {
                hp++;
            } else {
                hp--;
            }
        }

        if (hp == 0) return -1;
        hp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cand) hp++;
        }
        if (hp > nums.length / 2) return cand;
        else return -1;
    }
}