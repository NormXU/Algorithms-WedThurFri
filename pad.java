
null  <- 1  <-  8  <-  9  -> null
                      pre
                             cur
                            next
ListNode reverse(ListNode head){
  ListNode pre  = null;
  ListNode cur  = head;
  while(cur != null){
    ListNode tmp = cur.next;
    cur.next     = pre;
    pre          = cur;
    cur          = tmp
  }
  return pre;

}

Queue<Integer> dq = new LinkedList<>();

        5

      /    \

    3        8

  /   \        \

1      4        11

中左右


void preOrder(ListNode root){
  if (root == null) return;
  print(root.value);
  preOrder(root.left);
  preOrder(root.right);
}

ListNode x = new ListNode(0);
int y = 10
return y

10





de                print
5
3 8                  5
8                    5 3
1 4 8                5 3
4 8                  5 3 1
  8                  5 3 1 4
  11                 5 3 1 4 8
                     5 3 1 4 8 11
deque pq;
pq.append(root)
while(!pq.isEmpty()){
  TreeNode cur = pq.popleft();
  print(cur.value)
  if (cur.right != null){
    pq.appendleft(cur.right)
  }
  if (cur.left != null){
    pq.appendleft(cur.left)
  }
}
