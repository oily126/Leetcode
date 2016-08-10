/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode last, ptr1, ptr2, ptr3;
        int cnt = 1;
        if (head == null) return true;
        ptr1 = head;
        ptr2 = ptr1.next;
        if (ptr2 != null) cnt++;
        last = null;
        while (ptr2 != null) {
            ptr3 = last;
            last = ptr1;
            ptr1 = ptr1.next;
            last.next = ptr3;
            ptr2 = ptr2.next;
            if (ptr2 != null) {
                cnt++;
                ptr2 = ptr2.next;
                if (ptr2 != null) cnt++;
            }
        }
        if (cnt % 2 != 0) {
            ptr1 = ptr1.next;
            ptr2 = last;
        } else {
            ptr2 = last;
        }
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val != ptr2.val) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1 == ptr2;
    }
}