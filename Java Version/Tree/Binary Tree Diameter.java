Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.

If there does not exist any such paths, return 0.

Examples

    5

  /    \

2      11

     /    \

    6     14

The diameter of this tree is 4 (2 → 5 → 11 → 14)

对于每一个节点，我要获得左节点的高度和右节点的高度

public class Solution{
  public int getHeight(TreeNode root){
    if (root != null) {
      return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    return 0;
  }

  public int Diameter(TreeNode root){
    if (root == null) {
      return 0;
    }
    int leftH  = getHeight(root.left);
    int rightH = getHeight(root.right);

    int leftDiameter = Diameter(root.left);
    int rightDiameter = Diameter(root.right);

    return Math.max(leftH + rightH + 1, Math.max(leftDiameter, rightDiameter));
  }
}
