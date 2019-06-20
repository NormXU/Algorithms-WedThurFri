Example:
Given the below binary tree and target = 16,

              5
             / \
            4   8
           /   / \
          1    3  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.

public class Solution {
  private boolean flag;
  public boolean exist(TreeNode root, int target) {
    flag = false;
    helper(root, 0, target);
    return flag;
  }
  private void helper(TreeNode root, int curSum, int target){
    if (root == null) {
      return;
    }
    curSum += root.key;
    if (root.left == null && root.right == null && curSum == target) {
      flag = true;
      return;
    }
    helper(root.left, curSum, target);
    helper(root.right, curSum, target);
  }
}
