Given a binary tree in which each node contains an integer number. Find the maximum possible subpath
sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes,
and the subpath is allowed to contain only one node).

Assumptions

The root of given binary tree is not null
Examples

   -5

  /    \

2      11

     /    \

    6     14

           /

        -3

The maximum path sum is 11 + 14 = 25

public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }

  private int helper(TreeNode root, int[] max){
    if (root == null) {
      return 0;
    }
    int LValue = helper(root.left, max);
    int RValue = helper(root.right, max);
    int sin    = Math.max(Math.max(LValue, RValue), 0);
    max[0]     = Math.max(max[0], sin);
    return sin;
  }
}
