package leetcode.util;

public class ListNodeUtils {

    public static ListNode makeListNodes(int[] contents) {
        ListNode head = new ListNode(contents[0]);
        ListNode next = head;
        for(int i = 1; i < contents.length; i++) {
            next.next = new ListNode(contents[i]);
            next = next.next;
        }

        return head;
    }

    public static void printListNode(ListNode ln) {
        while(ln != null) {
            System.out.print(ln.val + " -> ");
            ln = ln.next;
        }
        System.out.println();
    }

}
