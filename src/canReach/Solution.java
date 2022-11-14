package canReach;

class Solution {
    public boolean canReach(int[] arr, int start) {

        return process(arr, start);
    }

    private boolean process(int[] arr, int start) {
        if (start >= arr.length || start < 0 || arr[start] == -1) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        int step = arr[start];
        arr[start] = -1;
        boolean p1 = process(arr, start + step);
        arr[start] = step;


        step = arr[start];
        arr[start] = -1;
        boolean p2 = process(arr, start - step);
        arr[start] = step;
        return p1 || p2;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(new Solution().canReach(arr, start));
    }
}