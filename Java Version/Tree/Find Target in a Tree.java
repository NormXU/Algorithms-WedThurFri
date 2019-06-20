Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.

// O(n) solution;  How do you find if there is a subarray sum to target value

public class Solution {
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if (root == null) {
      return false;
    }
    Set<Integer> prefixSums = new HashSet<>();
    prefixSums.add(0);
    return helper(root, prefixSums, 0, target);
  }

  private boolean helper(TreeNode root, Set<Integer> prefixSums, int preSum, int target){
    preSum += root.value;
    if (prefixSums.contains(preSum - target)) {
      return true;
    }
    // The add(E e) method is used to add the specified element to this set if it is not already present.
    // If this set already contains the element, the call leaves the set unchanged and returns false.
    boolean needRemove = prefixSums.add(preSum);
    if (root.left != null && helper(root.left, prefixSums, preSum, target)) {
      return true;
    }
    if (root.right != null && helper(root.right, prefixSums, preSum, target)) {
      return true;
    }
    if (needRemove) {
      prefixSums.remove(preSum);
    }
    return false;
  }
}
