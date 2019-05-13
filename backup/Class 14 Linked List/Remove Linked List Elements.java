/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    // Write your solution here
    ListNode dummyHead = new ListNode(0);
    ListNode cur1       = dummyHead;
    ListNode cur2       = head;

    while(cur2 != null){
      if(cur2.value == val){
        cur2 = cur2.next;
      }else{
        cur1.next = cur2;
        cur2 = cur2.next;
        cur1 = cur1.next;
      }
    }
    cur1.next = null;
    return dummyHead.next;

  }
}
