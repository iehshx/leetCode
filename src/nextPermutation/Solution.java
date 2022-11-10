package nextPermutation;

class Solution {
    public void nextPermutation(int[] nums) {
        int N = nums.length;
        int firstLess = -1;

//        [1,3,5,4,0]

        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstLess = i;
                break;
            }
        }
        //        firstLess == 1
        //没有找到第一个小的数字
        if (firstLess < 0) {
            reverseArr(nums, 0, N - 1);
        } else {
            //找到右边   比firstLess大的数字 然后交换过来
            int rightMore = -1;
            for (int i = N - 1; i > firstLess; i--) {
                if (nums[i] > nums[firstLess]) {
                    rightMore = i;
                    break;
                }
            }
            swap(nums, firstLess, rightMore);
            //14530
            //14035
            reverseArr(nums, firstLess + 1, N - 1);
        }


    }


    void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseArr(int[] nums, int L, int R) {
        while (L <= R)
            swap(nums, L++, R--);
    }

    public static void main(String[] args) {
        int nums[] = {1, 1};
        new Solution().nextPermutation(nums);
        for (int item : nums
        ) {
            System.out.println(item);
        }
    }
}