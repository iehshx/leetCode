package deleteNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    static ListNode node9 = new ListNode(9);
    static ListNode node1 = new ListNode(1, node9);
    static ListNode node5 = new ListNode(5, node1);
    static ListNode headNode = new ListNode(4, node5);

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode nextNode = node.next;
        ListNode nextNextNode = node.next.next;
        node.val = nextNode.val;
        node.next = nextNextNode;
    }

    public static void main(String[] args) {
        new Solution().deleteNode(node5);
        System.out.println("1");
    }
}