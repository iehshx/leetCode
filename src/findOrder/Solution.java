package findOrder;

class Solution {

    class Node {
        int in;
        int from;
        int to;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {


        for (int[] prereuisity : prerequisites) {
            int from = prereuisity[0];
            int to = prereuisity[1];
        }

        return null;

    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
    }
}