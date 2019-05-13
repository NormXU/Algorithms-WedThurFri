Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

public TreeNode invertTreeNode(TreeNode root){
  if (root == null) {
    return null;
  }
  root.left = invertTreeNode(root.left);
  root.right = invertTreeNode(root.right);

  TreeNode tmp = root.left;
  root.left    = root.right;
  root.right   = tmp;

  return root;

}
