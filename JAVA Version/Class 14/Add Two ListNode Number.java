Description
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)

Output: 7 -> 0 -> 8


Case1:
a: 2    4    3
b: 5    6    4
___________________
s: 7    0(1)  8

Case2:
a: 9    8
b: 1    1
___________________
s: 0    0(1)  1

public class AddTwoNumbers{
  public ListNode addTwoNumbers(ListNode one, ListNode two){
    if (one == null && two == null) {
      return null;
    } else if(one == null || two == null){
      return one == null ? two : one;
    }
    int sum = 0;
    ListNode dummy = new ListNode(0);
    ListNode cur   = dummy;
    while (one != null || two != null) {
      sum = sum / 10;
      if (one != null) {
        sum = sum + one.value;
        one = one.next;
      }
      if (two != null) {
        sum = two + one.value;
        two = two.next;
      }
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
    }
    if (sum / 10 != 0) {
      cur.next = new ListNode(sum / 10)
    }
    return dummy.next;
  }
}
