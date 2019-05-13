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
  public int secondLargest(TreeNode root) {
    // Write your solution here
    int secondMax;
    TreeNode pre = root;
    TreeNode cur = root;
    while(cur.right != null){
      pre = cur;
      cur = cur.right;
    }
    if(cur.left != null){
      cur = cur.left;
      while(cur.right != null){
        cur = cur.right;
      }
      secondMax = cur.key;
    }
    else{
      if(cur == root && pre == root){
        secondMax = Integer.MIN_VALUE;
      }
      else{
        secondMax = pre.key;
      }
    }

    return secondMax;
  }
}
