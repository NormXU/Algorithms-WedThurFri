public class Solution{
  public boolean hasCycle(ListNode head){
    if (head == null || head.next == null) {
      return;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast == null || fast.next == null){
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
