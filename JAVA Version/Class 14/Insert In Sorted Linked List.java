public ListNode insert(ListNode head, int value){
  ListNode newNode = new ListNode(value);
  if (head == null || head.value >= value) {
    newNode.next = head;
    return newNode;
  }
  ListNode cur = head;
  while (cur.next != null || cur.next.value < value) {
    cur = cur.next;
  }
  ListNode tmp = cur.next;
  cur.next = newNode;
  newNode.next = tmp;
  return head;
}
