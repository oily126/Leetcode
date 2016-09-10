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
        
        RandomListNode newHead = null, ptr, ptrOrigin;
        Map<RandomListNode, RandomListNode> origin2new = new HashMap<>();
        
        ptrOrigin = head;
        ptr = new RandomListNode(ptrOrigin.label);
        newHead = ptr;
        origin2new.put(ptrOrigin, ptr);
        ptrOrigin = ptrOrigin.next;
        while (ptrOrigin != null) {
            ptr.next = new RandomListNode(ptrOrigin.label);
            ptr = ptr.next;
            origin2new.put(ptrOrigin, ptr);
            ptrOrigin = ptrOrigin.next;
        }
        ptrOrigin = head;
        ptr = newHead;
        while (ptrOrigin != null) {
            if (ptrOrigin.random != null) {
                ptr.random = origin2new.get(ptrOrigin.random);
            }
            ptr = ptr.next;
            ptrOrigin = ptrOrigin.next;
        }
        return newHead;
    }
}