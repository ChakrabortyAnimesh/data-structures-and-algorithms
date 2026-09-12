/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node points to the actual head
        ListNode dummy = new ListNode(0, head);
        
        // prev is the last node we know is unique
        ListNode prev = dummy;
        
        while (head != null) {
            // Check if it's a beginning of a duplicates sublist
            if (head.next != null && head.val == head.next.val) {
                // Move head to the very last node of this duplicate cluster
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Skip all duplicates by linking prev to the node AFTER the cluster
                prev.next = head.next;
            } else {
                // No duplicate detected, simply advance the 'prev' pointer
                prev = prev.next;
            }
            
            // Advance head to evaluate the next potential number
            head = head.next;
        }
        
        // Return the actual head of the modified list
        return dummy.next;
    }
}