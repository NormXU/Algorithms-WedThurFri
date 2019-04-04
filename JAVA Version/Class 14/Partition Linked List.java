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
  public ListNode partition(ListNode head, int target) {
    // Write your solution here
    if(head == null || head.next == null){
      return head;
    }
    ListNode smallerHead = new ListNode(0);
    ListNode largerHead  = new ListNode(0);

    ListNode curSmall    = smallerHead;
    ListNode curLarge    = largerHead;
    ListNode cur = head;
    while(cur != null){
      if(cur.value < target){
        curSmall.next = cur;
        cur = cur.next;
        curSmall = curSmall.next;
      }else{
        curLarge.next = cur;
        cur = cur.next;
        curLarge = curLarge.next;
      }
    }
    curSmall.next = largerHead.next;
    // Un Link the last node in the large partition
    curLarge.next = null;
    return smallerHead.next;
  }
}
