
class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value) {
    this.value = value;
    next = null;
  }
}

public class Solution {
  public ListNode findMiddleNode(ListNode head) {
    // Write your solution here
    if(head == null){return null;}
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
