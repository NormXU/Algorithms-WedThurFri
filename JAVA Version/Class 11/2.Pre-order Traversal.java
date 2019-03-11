Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Pre-order traversal is [5, 3, 1, 4, 8, 11]

public class TreeNode{
  public int key;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int key){
    this.key = key;
  }
}

public class Solution {
  public List<Integer> preOrder(TreeNode root) {
    // Write your solution here
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
    res.add(root.key);
    helper(root.left, res);
    helper(root.right, res);
  }
}
