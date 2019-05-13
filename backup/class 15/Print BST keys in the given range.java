[k1=16,   <- x ->  ,k2=50]

     10
     /\
  5      15
 /\      /\
2  7   12  20


void inOrder(TreeNode root, int lower, int upper){
  if (root == null) {
    return;
  }
  if (root.value > lower) { // 只要根比 lower bound稍微大一些，就可以去左边看一看
    inOrder(root.left);
  }
  if (root.value >= lower && root.value <= upper) {
    System.out.println(root.value);
  }
  if (root.value < upper) {
    inOrder(root.right);
  }
}
