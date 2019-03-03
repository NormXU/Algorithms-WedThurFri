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
    ListNode curr = head;
    while(curr.next != null){
      if(curr.value <= target && curr.next.value > target){
          ListNode newNode = new ListNode(target);
          ListNode temp = curr.next;
          curr.next = newNode;
          newNode.next = temp;
          return head;
      }
      curr = curr.next;
    }
    return head;
  }
}
