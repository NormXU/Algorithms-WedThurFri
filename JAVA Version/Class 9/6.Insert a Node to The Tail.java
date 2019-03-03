class ListNode{
  public int value;
  public ListNode next;
  public ListNode(int value){
    this.value = value;
    next = null;
  }

}

public class Solution {
  public ListNode insertNode(ListNode head, int target) {
    // Write your solution here
    if(head == null){
      ListNode n = new ListNode(target);
      return n;}
    ListNode curr = head;
    while(curr.next != null){
      curr = curr.next;
    }
    ListNode newNode = new ListNode(target);
    curr.next = newNode;
    return head;
  }
}
