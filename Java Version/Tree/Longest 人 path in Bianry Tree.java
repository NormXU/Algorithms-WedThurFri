Find the maximum possible sum from one leaf node to another 必须是从一个leaf到达另一个leaf

Recursion Three Steps
1. What do you want from lchild and rchild
  - Max Single Path with leaf node in my left subtree
  - Max Single Path with leaf node in my right subtree

2. In the current layer
  - if root.left != null && root.right != null:
        update global max with (1) + (2) + root.value

3. What do you want to report to your parent
  - max((1), (2)) + root.value


  Examples

  -15

  /    \

2      11

     /    \

    6     14

The maximum path sum is 6 + 11 + 14 = 31.





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
    MaxPathSum(root,result);
    return result[0];
  }
  private int MaxPathSum(TreeNode root, int[] globalMax){
      if(root == null){
          return 0;
      }
      int lcost = MaxPathSum(root.left, globalMax);
      int rcost = MaxPathSum(root.right, globalMax);

      int cursum = lcost + rcost + root.key;

      if(cursum > globalMax[0] && (root.left != null && root.right != null)){
          globalMax[0] = cursum;
      }

      if(root.left==null){
          return root.key+rcost;
      } else if(root.right == null){
          return root.key+lcost;
      }
      return Math.max(lcost,rcost)+root.key;

  }
}
