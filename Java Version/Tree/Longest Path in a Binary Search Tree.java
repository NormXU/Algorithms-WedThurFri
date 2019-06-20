Find the maximum possible sum from one leaf node to another
from any node to any node

1. What do you want from lchild and rchild ?
Max single path in my left subtree
Max single path in my right subtree

2. At Current Layer
如果左边孩子的值比0小，那么我还不如不带着它玩儿
同理，如果右边孩子的值比0小，我不带他玩
所以
global max = root.value + max(a, 0) + max(b, 0)

Examples

   -1

  /    \

2      11

     /    \

    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

3. What do you report to your parent ?
return root.value + max(a, b, 0);
================================================================================
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
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] result = new int[]{Integer.MIN_VALUE};
    maxPath(root,result);
    return result[0];
  }
  private int maxPath(TreeNode root, int[] maxValue){
      if(root==null){
          return 0;
      }
      int Lvalue = Math.max(maxPath(root.left, maxValue),0);
      int Rvalue = Math.max(maxPath(root.right, maxValue),0);

      maxValue[0] = Math.max(maxValue[0], Lvalue+Rvalue+root.key);

      return Math.max(Lvalue, Rvalue) + root.key;
  }
}
