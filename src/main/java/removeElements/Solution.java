package removeElements;


class ListNode {

    int val;

    ListNode next;


    ListNode() {
    }


    ListNode(int val) {
        this.val = val;
    }


    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        ListNode pre = head;
        while (temp != null) {
            if (temp.val == val) {
                ListNode next = temp.next;
                pre.next = next;
                temp = next;
            }
            pre = temp;
            if (temp != null)
                temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        int val = 6;
        head = new Solution().removeElements(head, 6);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}