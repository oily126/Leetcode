/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
         if (head == null) {
             return null;
         }
         
         RandomListNode ptrOrigin, ptr, next;
         ptrOrigin = head;
         while (ptrOrigin != null) {
             ptr = new RandomListNode(ptrOrigin.label);
             ptr.next = ptrOrigin.next;
             ptrOrigin.next = ptr;
             ptrOrigin = ptrOrigin.next.next;
         }
         ptrOrigin = head;
         while (ptrOrigin != null) {
             if (ptrOrigin.random != null) {
                 ptrOrigin.next.random = ptrOrigin.random.next;
             }
             ptrOrigin = ptrOrigin.next.next;
         }
         ptr = head.next;
         ptrOrigin = head;
         while (ptrOrigin != null) {
             next = ptrOrigin.next.next;
             if (next != null) {
                 ptrOrigin.next.next = next.next;
             }
             ptrOrigin.next = next;
             ptrOrigin = next;
         }
         
         return ptr;
    }
}