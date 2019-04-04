# Recursion
public void inOrder(TreeNode root){
  if (root == null) {
    return;
  }
  inOrder(root.left);
  System.out.println(root.key);
  inOrder(root.right);
}


# Iterative
      5
    /   \
  2      8
 /\
1  3

Stack     print            helper
5                             5
5                             2
5 2                           1
5 2 1                        null
5 2        1                   1
5          1 2                 2
5          1 2 3               3


public void inOrder(TreeNode root){
  if (root == null) {
    return;
  }
  Deque<TreeNode> stack = new LinkedList<>();
  TreeNode helper = root;
  while(helper != null || !stack.isEmpty()){
    if (helper != null) {
      stack.offerFirst(helper);
      helper = helper.left;
    }else{
      helper = stack.pollFirst();
      System.out.println(helper.value)
      helper = helper.right;
    }
  }
}
