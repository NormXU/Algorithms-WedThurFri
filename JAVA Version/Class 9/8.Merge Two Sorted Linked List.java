class ListNode{
  public int value;
  public ListNode next;
  public ListNode(int value){
    this.value = value;
    next = null;
  }

}


public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    // Write your solution here
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    ListNode curr1 = one;
    ListNode curr2 = two;
    while(curr1 != null && curr2 != null){
      if(curr1.value <= curr2.value){
        head.next = curr1;
        curr1 = curr1.next;
      }
      else{
        head.next = curr2;
        curr2 = curr2.next;
      }
      head = head.next;
    }
    if(curr1 == null){
      head.next = curr2;
    }
    if(curr2 == null){
      head.next = curr1;
    }
    return dummy.next;
  }
}
