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
  public ListNode reorder(ListNode head) {
    // Write your solution here
    if(head == null || head.next == null){
      return head;
    }
    ListNode mid = finMid(head);
    ListNode head2 = mid.next;
    ListNode cur1 = head;
    ListNode cur2 = reverseLink(head2);
    mid.next = null;

    ListNode dummyHead = new ListNode(0);
    ListNode cur3      = dummyHead;

    int flag = 0;
    while(cur1 != null && cur2 != null){
      if(flag == 0){
        cur3.next = cur1;
        cur1 = cur1.next;
        cur3 = cur3.next;
        flag = 1;
      }else{
        cur3.next = cur2;
        cur2 = cur2.next;
        cur3 = cur3.next;
        flag = 0;
      }
    }
    if(cur1 == null){
      cur3.next = cur2;
    } else{
      cur3.next = cur1;
    }
    return dummyHead.next;

  }
  private ListNode finMid(ListNode head){
    if(head == null || head.next == null){
      return head;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while(fast != null && fast.next != null){
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  private ListNode reverseLink(ListNode head){
     if(head == null || head.next == null){
       return head;
     }
    ListNode prev = null;
    ListNode cur  = head;
    ListNode next = null;
    while(cur != null){
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
