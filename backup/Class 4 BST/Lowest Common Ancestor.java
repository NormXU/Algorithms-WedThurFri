Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9
"""
Case 0: 若a与b是直系亲属
0.0 if both return NULL, then finally return NULL
0.1 if one side return NOT NULL and the other side return NULL
      return NOT NULL
0.2 if both return NOT NULL, return myself


Case 1: 若a与b是旁系亲属
1.0 if both return NULL,
      then report NULL
1.1 if one side return not null and the other return null
      return the side with not null
"""
===============================================================================

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    if(root == null || root == one || root == two) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if(left != null && right != null) {
      return root;
    }
    return left == null ? right : left;

  }
}
