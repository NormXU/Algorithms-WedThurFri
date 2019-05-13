class ListNode{
  public int value;
  public ListNode next;
  ListNode(int value){
    this.value = value;
    next = null;
  }

}

public class Solution{
  public ListNode middleNode(ListNode head){
    if (head == null || head.next == null) {
      return head;

    }
    ListNode slow = head;
    ListNode fast = head.next;

    // 首先判断 fast 是否是null， 若不是，再去判断 fast的下一个是不是null
    // 不能写成 || 因为有可能出现 OutOfBoundary 的错误
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

}
