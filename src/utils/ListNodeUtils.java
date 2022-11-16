package utils;

public class ListNodeUtils {

    public static ListNode getListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode root = head;
        for (int i = 1; i < nums.length; i++) {
            root.next = new ListNode(nums[i]);
            root = root.next;
        }

        return head;
    }

    public static ListNode getDetectCycle(int[] nums, int pos) {
        ListNode head = new ListNode(nums[0]);
        ListNode root = head;
        ListNode tail = head;
        for (int i = 1; i < nums.length; i++) {
            root.next = new ListNode(nums[i]);
            root = root.next;
        }
        tail = root;
        root = head;
        for (int i = 0; i < pos; i++) {
            root = root.next;
        }
        tail.next = root;
        return head;
    }
}
