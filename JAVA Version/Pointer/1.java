public ListNode merge(ListNode h1, ListNode h2){
  ListNode dummy = new ListNode(0);
  ListNode c = dummy; c1 = h1; c2 = h2;
  while (c1 != null && c2 != null) {
    if (c1.value < c2.value) {
      c.next = c1;
      c1 = c1.next;
    } else{
      c.next = c2;
      c2 = c2.next;
    }
    c = c.next;

    if (c1 != null) {
      c.next = c1;

    }else if (c2 != null) {
      c.next = c2;
    }
    return dummy.next;

  }
}


public ListNode partition(ListNode head, int target){
  if (head == null || head.next == null) {
    return head;
  }
  ListNode smallDummy = new ListNode(0), largeDummy = new ListNode(0);
  ListNode small = smallDummy, large = largeDummy, cur = head;
  while(curr != null){
    if (curr.value < target) {
      small.next = curr;
      small = small.next;
    }else{
      large.next = curr;
      large = large.next;
    }

  }
}
