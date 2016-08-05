/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode ptr1 = l1, ptr2 = l2, head, ptr;
        if (ptr1.val > ptr2.val) {
            ptr = head = ptr2;
            ptr2 = ptr2.next;
        } else {
            ptr = head = ptr1;
            ptr1 = ptr1.next;
        }
        
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val > ptr2.val) {
                ptr.next = ptr2;
                ptr2 = ptr2.next;
            } else {
                ptr.next = ptr1;
                ptr1 = ptr1.next;
            }
            ptr = ptr.next;
        }
        
        if (ptr1 == null) {
            ptr.next = ptr2;
        } else {
            ptr.next = ptr1;
        }
        
        return head;
    }
}