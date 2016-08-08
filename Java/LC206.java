/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur, last, next;
        cur = head;
        last = null;
        while (cur != null) {
            next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        return last;
    }
}