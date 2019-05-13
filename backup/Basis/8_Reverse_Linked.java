class ListNode {
  public int value;
  public ListNode next;
  public ListNode(int v){
    value = v;
}

class Solution{
  public ListNode reverse(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode prev = null, curr = head;
    ListNode next = null;
    while(curr != null){
      next = curr.next;
      cur.next = prev;
      prev = cur;
      cur = next;

    }
    return prev;
  }
}
