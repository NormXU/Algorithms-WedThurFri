To Judge Whether It is a Balanced Tree Or Not

// Time Complexity: O(n logn)

// O(height). Since it is a Balanced Tree, the height is O(logn)
public boolean isBalaced(TreeNode root){
  if (root == null) {
    return true;
  }
  int diff = getHeight(root.left) - getHeight(root.right);
  if (Math.abs(diff) > 1) {
    return false;
  }
  return isBalaced(root.left) && isBalaced(root.right);
}

// O(n)
private int getHeight(TreeNode root){
  if (root == null) {
    return 0;
  }
  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}
