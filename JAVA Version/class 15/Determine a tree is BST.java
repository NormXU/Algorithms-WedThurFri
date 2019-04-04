public boolean isBST(TreeNode root){
  if (root == null) {
    return true;
  }
  return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
public boolean isBST(TreeNode root, int l, int r){
  if (root == null) {
    return true;
  }
  if (l< root.key && root.key < r && isBST(root.left, l, root.key) && isBST(root.right, root.key, r)) {
    return true;
  }
  return false;
}


                    10 (min=-inf, max=inf)
              /                       \
    5(min=-inf, max=5)                  15(min=10, max=+inf)
     /                 \                            /\
2(min=-inf, max=5) 7(min=5, max=10)               12     20
