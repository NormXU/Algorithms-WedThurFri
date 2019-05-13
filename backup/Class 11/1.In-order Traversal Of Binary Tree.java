Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

In-order traversal is [1, 3, 4, 5, 8, 11]

public class TreeNode{
  public int key;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int key){
    this.key = key;
  }

}

public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    helper(root, res);
    return res;

  }

 private void helper(TreeNode root, List<Integer>res){
   if (root == null) {
     return;
   }
   helper(root.left, res);
   res.add(root.key);
   helper(root.right, res);
 }
}
