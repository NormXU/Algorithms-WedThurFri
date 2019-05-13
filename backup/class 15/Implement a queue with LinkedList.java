class ListNode{
  int value;
  ListNode next;
  public ListNode(int value){
    this.value = value;
  }
}

# 1
# 3
# 5
node
    head
1 -> 3
    Tail

class Queue{
  private ListNode head;
  private ListNode tail;
  public Queue(){
    head = null;
    tail = null;
  }

  public void push(int value){
    if (head == null) {
      head = new ListNode(value);
      tail = head;
    }else{
      ListNode newNode = new ListNode(value);
      tail.next = newNode
      tail = tail.next;
    }
  }

  public Integer pop(){
    if (head == null) {
      return null;
    }
    ListNode node = head;
    head = head.next;
    if (head == null) {
      tail = null;
    }
    node.next = null;
    return node.value;
  }
}
