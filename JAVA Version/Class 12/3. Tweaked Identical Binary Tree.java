Determine whether two given binary trees are identical assuming any number of ‘tweak’s are allowed. A tweak is defined as a swap of the children of one node in the tree.

Examples

        5

      /    \

    3        8

  /   \

1      4

and

        5

      /    \

    8        3

           /   \

          1     4


Recursion
-subproblem:
             TW(AL, BL) TW(AR, BR) TW(AL, BR) TW(AR, BL)

-Recursion Rull:
              (TW(AL, BR) && TW(AR, BL)) || (TW(AL, BL) && TW(AR, BR))  && (A.key == B.key) return true
-base case:
             null && null return true     null && not null  return false


"""
Codes:
"""

public class Solution {
 public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
   // Write your solution here
   if(one == null && two == null){
     return true;
   }
   if( (one == null && two != null) || (one != null && two == null)){
     return false;
   }
   if(one.key != two.key){
     return false;
   }
   if((isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left))
        || (isTweakedIdentical(one.left, two.left)) ){
     return true;
   }
   return false;
 }
}
