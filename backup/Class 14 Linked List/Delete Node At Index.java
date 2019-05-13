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
  public ListNode deleteNode(ListNode head, int index) {
    // Write your solution here
    ListNode dummyHead = new ListNode(0);
    dummyHead.next     = head;
    ListNode prev      = dummyHead;
    ListNode cur        = head;
    while(index != 0 && cur != null){
      prev = cur;
      cur  = cur.next;
      index--;
    }
    if(cur != null){
      prev.next = cur.next;
    }
    return dummyHead.next;
  }
}


################################################################################
Examples

1 -> 2 -> 3 -> 4 -> NULL, indices = {0, 3, 5}, after deletion the list is 2 -> 3 -> NULL.
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
  public ListNode deleteNodes(ListNode head, int[] indices) {
    // Write your solution here
    if(indices.length == 0 || indices == null){
      return head;
    }
    ListNode dummyHead = new ListNode(0);
    ListNode R    = dummyHead;
    ListNode cur       = head;
    int cnt            = 0;
    int i              = 0;
    int length         = indices.length;

    while(cur != null){
      if(cnt == indices[i]){
        cur = cur.next;
        i++;
      } else{
        R.next = cur;
        R = R.next;
        cur = cur.next;
      }
      cnt++;
      if(i == length){
        R.next = cur;
        return dummyHead.next;
      }
    }
    R.next = null;
    return dummyHead.next;

  }
}
