/*
Check if two given binary trees are identical. Identical means the equal valued keys are at the same position in the two binary trees.
*/
Examples



        5

      /    \

    3        8

and

        5

      /    \

    3        8

are identical trees.

"""
Recursion 三部曲
"""
-subproblem：
            isIdentical(one.left, two.left),  isIdentical(one.right, two.right)

-recursion rule:
            isIdentical(one.left, two.left) &&  isIdentical(one.right, two.right) %% (one.key == two.key)

-base case:
           (one == null) && (two == null)    return true



# Code:

public class Solution{
  public boolean isIdentical(TreeNode one, TreeNode two){
    if (one == null && two == null) {
      return true;
    }
    if ( (one == null && two != null) || (one != null && two == null) ) {
      return true;
    }
    if ( one.key == two.key && isIdentical(one.left, two.left) && isIdentical(one.right, two.right) ) {
      return true;
    }
    return false;
  }

}
