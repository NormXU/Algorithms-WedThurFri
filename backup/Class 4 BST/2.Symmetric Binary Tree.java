Check if a given binary tree is symmetric.
Examples

        5

      /    \

    3        3

  /   \    /   \

1      4  4      1

is symmetric.

        5

      /    \

    3        3

  /   \    /   \

1      4  1      4

is not symmetric.

Recursion
-subproblem:
             isSym(root.left) isSym(root.right)

-Recursion Rull:
             isSym(A.left, B.right) && isSym(A.right, B.left) && A.key == B.key  return true
-base case:
             null && null return true     null && not null  return false



"""
Code:

"""
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */

 
 public class Solution {
   public boolean isSymmetric(TreeNode root) {
     // Write your solution here
     if(root == null){
       return true;
     }
     return isSym(root.left, root.right);
   }
   private boolean isSym(TreeNode A, TreeNode B){
     if(A == null && B == null){
       return true;
     }
     if((A == null && B != null) || (A != null && B == null)){
       return false;
     }
     if( (A.key == B.key) && ( isSym(A.left, B.right) ) && ( isSym(A.right, B.left) ) ){
       return true;
     }
     return false;
   }
 }
