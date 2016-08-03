/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2, ptr = null, head = null;
        int carry = 0, val = 0;
        
        while (ptr1 != null || ptr2 != null) {
            val = carry;
            if (ptr1 != null) {
                val += ptr1.val;
                ptr1 = ptr1.next;
            }
            if (ptr2 != null) {
                val += ptr2.val;
                ptr2 = ptr2.next;
            }
            
            carry = val / 10;
            val %= 10;
            
            if (null == ptr) {
                ptr = new ListNode(val);
                head = ptr;
            } else {
                ptr.next = new ListNode(val);
                ptr = ptr.next;
            }
        }
        
        if (carry != 0) {
            ptr.next = new ListNode(carry);
        }
        return head;
    }
}