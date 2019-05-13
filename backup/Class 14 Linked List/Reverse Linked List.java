class Solution{
  public ListNode reverse(ListNode head){
    if (head == null || head.next == null) {
      return head;
    }
    ListNode cur = head;
    ListNode prev = null;
    ListNode next = null
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
