struct Node{
  Node* next;
  int value;
  Node(int v) : value(v), next(NULL){};
}

void reverseLL(Node* head, Node* head2, Node* prev){
    if (!head) {
      return;
    }
    Node* next = head -> next;
    head -> next = prev;
    if (!next) {
      head2 = head;
      return;
    }
    reverseLL(next, head2, head);
}
