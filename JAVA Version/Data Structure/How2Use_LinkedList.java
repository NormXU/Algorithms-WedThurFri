class ListNode{
  public int value;
  public ListNode next;
  public ListNode(int value){
    this.value = value;
    next = null;
  }
}

public class Solution{
  public ListNode generate(int n){
    ListNode head = new ListNode(0);
    ListNode cur = head;
    for (int i = 1;i < n ;i++ ) {
      cur.next = ListNode(i);
      cur = cur.next;
    }
    return head;
  }
}
