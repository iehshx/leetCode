package detectCycle;

import utils.ListNode;
import utils.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode slow = head.next;
        ListNode fast = null;
        if (slow != null) {

            fast = head.next.next;
        }
        if (fast == null) {
            return fast.next == slow ? slow : null;
        }

        while (fast != null) {
            if (slow == fast) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (slow != null) {
            if (slow == fast) {
                return slow;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 0, -4};
        ListNode head = ListNodeUtils.getDetectCycle(nums, 1);
        ListNode detectCycleNode = new Solution().detectCycle(head);
        System.out.println(detectCycleNode.val);
    }
}