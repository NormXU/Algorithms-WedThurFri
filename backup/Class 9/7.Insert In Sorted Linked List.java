class ListNode{
  public int value;
  public ListNode next;
  public ListNode(int value){
    this.value = value;
    next = null;
  }

}


public class Solution {
  public ListNode insert(ListNode head, int value) {
    // Write your solution here
    ListNode dummy = new ListNode(0);
    ListNode newNode = new ListNode(value);
    dummy.next = head;
    head = dummy;

    while(head.next != null && head.next.value < value){
      head = head.next;
    }
    ListNode tmp = head.next;
    head.next = newNode;
    newNode.next = tmp;
    return dummy.next;
  }
}
