Assume No duplicate values,
1 -> 2 -> 3 -> null   remove 2


ListNode remove(ListNode head, int value){
  if (head == null) {
    return null;
  } else if (head.value == value) {
    return head.next;
  }
  ListNode cur = head;
  while(cur.next != null && cur.next.value != value){
    cur = cur.next;
  }
  if (cur.next != null) {
    cur.next = cur.next.next;
  }
  return head;
}


ListNode get(ListNode head, int index){
  while(index > 0 && head != null){
    head = head.next;
    index--;
  }
  return head;
}
