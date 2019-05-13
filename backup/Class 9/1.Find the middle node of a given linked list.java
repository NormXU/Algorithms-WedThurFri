Assumption: the length > 0
双指针，一块一慢


Example:

L = 1 -> 2 -> 3 -> null, return 2


class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int value){
    this.value = value;
    next = null;
  }

}

public class Solution{
  public ListNode findMiddleNode(ListNode head){
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
