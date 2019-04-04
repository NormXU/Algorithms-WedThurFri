# Iterative
      5
    /   \
  2      8
 /\
1  3


左 右 中      --> reverse --> 中 右 左

1  3  2  8  5  --> reverse --> 5  8  2  3  1

================================================================================
// Drawbacks:
# We need to store everything in memory before we can get the whole post order
# traversal sequence
public void postOrder(TreeNode root){
  if (root == null) {
    return;
  }
  Deque<TreeNode> stack = new LinkedList<>();
  Deque<TreeNode> temp = new LinkedList<>();
  stack.offerFirst(root);
  while(!stack.isEmpty()){
    TreeNode cur = stack.pollFirst();
    temp.offerFirst(cur);

    if (cur.left != null) {
      stack.offerFirst(cur.left);
    }
    if (cur.right != null) {
      stack.offerFirst(cur.right);
    }

  }

  while(!temp.isEmpty()){
    System.out.println(temp.pollFirst().value);
  }
}

================================================================================
