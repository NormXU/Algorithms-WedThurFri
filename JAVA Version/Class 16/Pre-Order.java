# Iterative
      5
    /   \
  2      8
 /\
1  3

中  左  右




public void preOrder(TreeNode root){
  if (root == null) {
    return;
  }
  Deque<TreeNode> stack = new LinkedList<TreeNode>();
  stack.offerFirst(root);
  while(!stack.isEmpty()){
    TreeNode cur = stack.pollFirst();
    System.out.println(cur.value)
    if (cur.right != null) {
      stack.offerFirst(cur.right);
    }
    if (cur.left != null) {
      stack.offerFirst(cur.left);
    }
  }
}


List<Integer> result = new ArrayList<>()
# result.add()

Deque<Integer> stack = new LinkedList<>()
# stack.offerFirst()
# stack.pollFirst()
