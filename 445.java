/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<ListNode> s1 = new Stack<>();
    Stack<ListNode> s2 = new Stack<>();
    
    while (l1 != null) {
      s1.add(l1);
      l1 = l1.next;
    }
    while (l2 != null) {
      s2.add(l2);
      l2 = l2.next;
    }
    
    // re-using l1/l2 pointers
    l1 = null;
    l2 = null;
    
    int carry = 0;
    int a, b;
    
    while (!s1.isEmpty() || !s2.isEmpty()) {
      a = s1.isEmpty() ? 0 : s1.pop().val;
      b = s2.isEmpty() ? 0 : s2.pop().val;
      l1 = new ListNode((a+b+carry)%10);
      if (a + b + carry >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      l1.next = l2;
      l2 = l1;      
    }
    if (carry == 1) {
      l1 = new ListNode(carry);
      l1.next = l2;
      l2 = l1;
    }
    return l2;
  }
}
