Check if two nodes are cousins in a Binary Tree

Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.

Two nodes are cousins of each other if they are at same level and have different parents.

Example:

                      6

                  /     \

               3            5

            /     \      /    \

         7         8    1       2
7 and 1, result is TRUE

3 and 5, result is FALSE

7 and 5, result is FALSE


// Chech TreeNode a and TreeNode b is in the same level or not; If
// a and b are in the same level, check whether they have the same parents
// or not. Since it go through all the nodes in the tree, The Time Complexity is O(n)

// Space Complexty: It should be the height of the binary tree: O(h)

public class Solution{
  public boolean question2(TreeNode node, TreeNode a, TreeNode b){
    return (level(node, a, 1) == level(node, b, 1)) && (! isSibling(node, a, b));

  }

  private boolean isSibling(TreeNode root, TreeNode a, TreeNode b){
    if(root == null){
      return false;
    }
    return (node.left == a && root.right == b) || (node.left == a && root.right == b) || isSibling(node.left, a, b) || isSibling(node.right, a, b);
  }

  private int level(TreeNode root, TreeNode chid, int level){
    if(root == null) return 0;

    if(root == chid) return level;

    // Check Left Sub-Tree
    int l = level(root.left, chid, level+1);
    if(l != 0){
      return l;
    }
    return level(root.right, chid, level+1);

  }
}
