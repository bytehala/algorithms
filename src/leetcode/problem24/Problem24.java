package leetcode.problem24;

import leetcode.util.ListNode;
import leetcode.util.ListNodeUtils;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode zero = new ListNode(0);
        ListNode dummy = zero;
        zero.next = head;

        while (zero.next != null && zero.next.next != null) {
            ListNode one = zero.next;
            ListNode two = zero.next.next;

            one.next = two.next;
            two.next = one;
            zero.next = two;

            zero = one;
        }

        return dummy.next;
    }
}

public class Problem24 {

    public static void main(String[] args) {
        Solution s = new Solution();
        // Call method below:

        ListNode head;

//        head = ListNodeUtils.makeListNodes(new int[]{1, 2, 3, 4});
//        head = ListNodeUtils.makeListNodes(new int[]{1, 2, 3});
//        head = ListNodeUtils.makeListNodes(new int[]{1, 2});
//        head = ListNodeUtils.makeListNodes(new int[]{1});
        head = null;
        ListNodeUtils.printListNode(s.swapPairs(head));

    }
}
