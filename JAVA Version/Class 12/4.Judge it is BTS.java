Determine if a given binary tree is binary search tree.There should no be duplicate keys in binary search tree.

Assumptions

You can assume the keys stored in the binary search tree can not be Integer.MIN_VALUE or Integer.MAX_VALUE.

Recursion:
  Subproblem:
        isBST(root.left)  && isBST(root.right)

  recursion rule:
        isBST(root.left) &&
        isBST(root.right) &&
        max(root.left) < root.key < min(root.right)

  base case:
        null -> true


public class Solution {
  public boolean isBST(TreeNode root) {
    // Write your solution here
    if(root == null){
      return true;
    }
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  private boolean isBST(TreeNode root, int l, int r){
    if(root == null){
      return true;
    }
    if(l < root.key && root.key < r && isBST(root.left, l, root.key) && isBST(root.right, root.key, r)){
      return true;
    }
    return false;
  }
}
