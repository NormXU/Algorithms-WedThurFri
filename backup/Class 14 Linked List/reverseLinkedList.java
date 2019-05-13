# Recursion Method
1 -> 2 -> 3 -> 4 -> 5 -> null
h    n    t
1 <- 2 <- 3 <- 4 <- 5 <- null
ListNode reverseLinkedList(ListNode head) {
  if (head == null || head.next == null) {
    return head;
  }
  ListNode newHead = reverseLinkedList(head.next);
  newHead.next = head;
  head.next    = null;
  return newHead;
}


Before
                  |
Node1 -> Node2 -> | Node3 -> Node4 -> ...
                  |
head  <- newHead    tmp


# Reverse By Pair
                  |
Node1 -> Node2 -> | Node3 -> Node4 -> ...
                  |
head     newHead     tmp

1 -> 2 -> 3 -> 4 -> 5 -> null
h    n    t
2 -> 1 -> 4 -> 3 -> 5 -> null
ListNode reverse(ListNode head){
  if (head == null || head.next == null) {
    return head;
  }
  ListNode newHead = head.next;
  head.next     = reverse(head.next.next);
  newHead.next     = head;
  return newHead;

}
