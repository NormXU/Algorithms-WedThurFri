Expected time complexity is O(n).

             -15
          /         \
         5          6
       /   \       /   \
      -8     1    3     9
res： 6+3+9 =  18

1. What do you want from your left child, right child ?
  left : maximum "root to leaf" path sum of left subtree
  right: maximum "root to leaf" path sum of right subtree
2. what should you do on current layers ?
  left + right + root.value
  update Global_Max if possible
3. what do you report to your parent?
  maximum path sum from root to leaf
================================================================================
   5           6
 /   \       /   \
 null 3     3     null
    5
 /     \
null    null

public class Solution{
  int maxVaule = Integer.MIN_VALUE;

  public int pathSum(TreeNode root){
    largestPath(root);
    return maxVaule;
  }

  private int largestPath(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = largestPath(root.left);
    int right = largestPath(root.right);

    if (root.left != null && root.right != null) {
      maxVaule = Math.max(maxVaule, left + right + root.value);
      return Math.max(left, right) + root.value;
    }

    return root.left == null ? right + root.value : left + root.value;
  }

}
