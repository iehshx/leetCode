package maximumUnits;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int sum = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize == 0) {
                return sum;
            } else {
                truckSize -= boxTypes[i][0];
                int size = boxTypes[i][0];
                if (truckSize < 0) {
                    size = boxTypes[i][0] + truckSize;
                    truckSize = 0;
                }
                sum += (boxTypes[i][1] * size);
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        System.out.println(new Solution().maximumUnits(boxTypes, truckSize));
    }
}