/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptrSlow = null, ptrFast = head, last = null;
        for (int i = 0; i < n - 1 && ptrFast != null; i++) {
            ptrFast = ptrFast.next;
        }
        if (ptrFast != null) {
            ptrSlow = head;
        }
        while (ptrFast != null && ptrFast.next != null) {
            last = ptrSlow;
            ptrFast = ptrFast.next;
            ptrSlow = ptrSlow.next;
        }
        
        if (ptrSlow != null) {
            if (ptrSlow != head) {
                last.next = ptrSlow.next;
            } else {
                return ptrSlow.next;
            }
        }
        
        return head;
    }
}