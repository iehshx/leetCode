package mergeKLists;

import utils.ListNode;
import utils.ListNodeUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return lists[0];
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < n; i++) {
            if (lists[i] != null)
                heap.add(lists[i]);
        }
        ListNode node = heap.poll();
        if (node != null) {
            ListNode head = new ListNode(node.val);
            ListNode cur = head;
            if (node.next != null)
                heap.add(node.next);
            while (!heap.isEmpty()) {
                node = heap.poll();
                cur.next = new ListNode(node.val);
                if (node.next != null)
                    heap.add(node.next);
                cur = cur.next;
            }

            return head;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        ListNode list1 = ListNodeUtils.getListNode(new int[]{1, 4, 5});
        ListNode list2 = ListNodeUtils.getListNode(new int[]{1, 3, 4});
        ListNode list3 = ListNodeUtils.getListNode(new int[]{2, 6});
        ListNode[] lists = new ListNode[3];
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;
        ListNode node = new Solution().mergeKLists(lists);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}