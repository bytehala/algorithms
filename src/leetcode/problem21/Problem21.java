package leetcode.problem21;

import leetcode.util.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode head;
        ListNode pointer;
        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            pointer = head;

            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            pointer = head;

            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = new ListNode(l1.val);
                pointer = pointer.next;

                l1 = l1.next;

            } else {
                pointer.next = new ListNode(l2.val);
                pointer = pointer.next;

                l2 = l2.next;
            }
        }

        if (l1 == null) {
            pointer.next = l2;
        } else {
            pointer.next = l1;
        }

        return head;
    }
}

public class Problem21 {

    public static void printListNode(ListNode ln) {
        while(ln != null) {
            System.out.print(ln.val + " -> ");
            ln = ln.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // Call method below:
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode res = s.mergeTwoLists(first, second);
        printListNode(res);
    }

}
