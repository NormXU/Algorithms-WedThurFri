public class TreeNode{
  public int key;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int key){
    this.key = key;
  }
}
public class Solution{
  public int countNode(TreeNode root){
    if (root == null) {
      return 0;
    }
    int left = countNode(root.left);
    int right = countNode(root.right);
    return left + right + 1;
  }
}
