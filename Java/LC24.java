/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ptr1, ptr2, ptr3, ptr0;
        
        ptr0 = ptr2 = ptr3 = null;
        ptr1 = head;
        while (ptr1 != null) {
            if (ptr1.next != null) {
                ptr2 = ptr1.next;
                ptr3 = ptr2.next;
                ptr2.next = ptr1;
                if (ptr0 != null) {
                    ptr0.next = ptr2;
                } else {
                    head = ptr2;
                }
                ptr1.next = ptr3;
                ptr0 = ptr1;
            } else {
                ptr3 = null;
            }
            ptr1 = ptr3;
        }
        return head;
    }
}