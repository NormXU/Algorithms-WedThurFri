public class TreeNode{
  public int key;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int key){
    this.key = key;
  }

}

public class Solution {
  public boolean isBalanced(TreeNode root) {
    // Write your solution here
    if(root == null){
      return true;
    }
    boolean left = isBalanced(root.left);
    boolean right = isBalanced(root.right);
    if(!left || !right){
      return false;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if(Math.abs(leftHeight - rightHeight) > 1){
      return false;
    }
    return true;
  }
  private int getHeight(TreeNode root){
    if(root == null){
      return 0;
    }
    return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
  }
}
