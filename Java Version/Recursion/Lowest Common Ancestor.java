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
===============================================================================
根的左侧的子树的common节点 left
根的右侧的子树的common节点 right
如果左子树和右子树都不是null，那么返回common节点--root
如果其中一个是null，比如说左子树，意味着在左子树中a和b是不存在共同祖先的，那么可能在右侧树中存在common，故返回另一侧


public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
    if (root == null || root == one || root == two) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, a, b);
    TreeNode right = lowestCommonAncestor(root.right, a, b);
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : null;
  }
}
