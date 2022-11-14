//package canWinNim;
//
//class Solution {
//    public static boolean canWinNim(int n) {
//        if (n <= 3) return true;
//        boolean p1 = canWinNim(n - 3);
//        boolean p2 = canWinNim(n - 2);
//        boolean p3 = canWinNim(n - 1);
//        return !(p1 && p2 && p3);
//    }
//
//    static boolean canWinNim2(int n) {
//        return n % 4 != 0;
//    }
//
//    static int jiecheng(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        return n * (n - 1);
//    }
//
//    public static void main(String[] args) {
////        for (int i = 1; i < 100; i++) {
////            if (canWinNim(i) != canWinNim2(i)){
////                System.out.println(i);
////            }
////        }
//        int n = 6;
//        for (int i = 1; i < 100; i++) {
//            System.out.println(jiecheng(6) < Math.pow(2, 6));
//        }
//
//    }
//}