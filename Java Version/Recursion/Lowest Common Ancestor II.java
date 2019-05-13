Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

public class TreeNodeP {
  public int key;
  public TreeNodeP left;
  public TreeNodeP right;
  public TreeNodeP parent;
  public TreeNodeP(int key, TreeNodeP parent) {
    this.key = key;
    this.parent = parent;
  }
}


 public class Solution {
   public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
     int l1 = length(one);
     int l2 = length(two);
     if (l1 < l2) {
       return helper(one, two, l2 - l1);
     } else {
       return helper(two, one, l1 - l2);
     }

   }

   private TreeNodeP helper(TreeNodeP shorter, TreeNodeP longer, int diff){
     while(diff > 0){
       longer = longer.parent;
       diff--;
     }
     while(longer != shorter){
       longer = longer.parent;
       shorter = shorter.parent;
     }
     return longer;
   }

   // find the length from root to leaf
   private int length(TreeNodeP node){
     int length = 0;
     while (node != null) {
       length++;
       node = node.parent;
     }
     return length;
   }
 }
