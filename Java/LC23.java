/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(10, new ListNodeComparator());
        ListNode head = null, ptr = null, ptr1 = null;
        for (ListNode tmp : lists) {
            if (tmp != null) pq.offer(tmp);
        }
        
        while (pq.size() != 0) {
            ptr1 = pq.poll();
            if (head == null) {
                head = ptr = ptr1;
            } else {
                ptr.next = ptr1;
                ptr = ptr.next;
            }
            ptr1 = ptr1.next;
            ptr.next = null;
            if (ptr1 != null) pq.offer(ptr1);
        }
        
        return head;
    }
    class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    }
}