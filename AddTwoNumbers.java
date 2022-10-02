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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = new ListNode();
        ListNode head = a;
        int carry = 0;
        while(carry == 1 || l1 != null || l2 !=null) {
            int sum = 0;
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            sum += carry;
            carry = sum/10;
            sum %= 10;
            a.next = new ListNode(sum);
            a = a.next;
        }
        return head.next;
    }
}
