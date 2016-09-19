/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        int cnt9 = 0;
        ListNode ptr = head;
        ListNode slowPtr, last = null;
        while (ptr != null) {
            if (ptr.val == 9) cnt9++; else cnt9 = 0;
            ptr = ptr.next;
        }
        ptr = head;
        slowPtr = head;
        for (int i = 0; i < cnt9; i++) ptr = ptr.next;
        while (ptr != null) {
            ptr = ptr.next;
            last = slowPtr;
            slowPtr = slowPtr.next;
        }
        if (last == null) {
            last = new ListNode(1);
            last.next = slowPtr;
            head = last;
        } else {
            last.val++;
        }
        while (slowPtr != null) {
            slowPtr.val = 0;
            slowPtr = slowPtr.next;
        }
        return head;
    }
}