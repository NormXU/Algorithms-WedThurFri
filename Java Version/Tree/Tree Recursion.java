Examples

   -1

  /    \

2      11

     /    \

    6    -14

Find maximum Path from leaf to node

6 -> 11 -> -1   ==> 这是一条potential path

void maxPath(TreeNode root, List<Integer> pathPrefix, int[] globalMax){
  // Base Case
  if (root == null) {
    return;
  }
  // 这个判断是判读走到了树的根底
  if (root.left == null && root.right) {
    globalMax[0] = Math.max(globalMax[0], sum(pathPrefix));
    return;
  }

  // Recursion Rules
  pathPrefix.add(root.value);
  maxPath(root.left, pathPrefix, globalMax);
  maxPath(root.right, pathPrefix, globalMax);
  pathPrefix.remove(pathPrefix.size()-1);
}
