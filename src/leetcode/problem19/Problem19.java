package leetcode.problem19;

import leetcode.util.ListNode;
import leetcode.util.ListNodeUtils;

class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ahead = dummy;
        ListNode behind = dummy;

        for(int i = 0; i <= n; i++) {
            ahead = ahead.next;
        }

        while(ahead != null) {
            ahead = ahead.next;
            behind = behind.next;
        }

        behind.next = behind.next.next;

        return dummy.next;
    }
}

public class Problem19 {

    public static void main(String[] args) {
        Solution s = new Solution();

        // Call method below:
        // 1,2,3,4,5 | 2 -> 1,2,3,5
        ListNode head;
//
        head = ListNodeUtils.makeListNodes(new int[]{1, 2, 3, 4, 5});
        ListNodeUtils.printListNode(s.removeNthFromEnd(head, 2));

        head = ListNodeUtils.makeListNodes(new int[]{1, 2});
        ListNodeUtils.printListNode(s.removeNthFromEnd(head, 1));

        head = ListNodeUtils.makeListNodes(new int[]{1, 2});
        ListNodeUtils.printListNode(s.removeNthFromEnd(head, 2));

        head = ListNodeUtils.makeListNodes(new int[]{1});
        ListNodeUtils.printListNode(s.removeNthFromEnd(head, 1));

    }
}
