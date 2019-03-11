Examples

        5

      /    \

    3        8

  /   \

1      4



return [1 3 4 5 8]


-subproblem
      getKey(root.left) getKey(root.left)
-recursion rule
      getKey(root.left) getKey(root.key) getKey(root.left)
-base case
      node == null return



public class Solution {
  public List<Integer> getKeys(TreeNode root) {
    // Write your solution here
    List<Integer> list = new ArrayList<Integer>();
    if(root == null){
      return list;
    }
    getKeys(root, list);
    return list;
  }
  private void getKeys(TreeNode root, List<Integer> list){
    if(root == null){
      return;
    }
    getKeys(root.left, list);
    list.add(root.key);
    getKeys(root.right, list);
  }
}
