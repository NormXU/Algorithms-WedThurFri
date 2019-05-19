public class Solution {
  public List<Integer> zigzag(TreeNode root){
    if (root == null) {
      return new LinkedList<Integer>();
    }
    Deque<TreeNode> deque = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    deque.offerFirst(root);
    int layer = 0;
    while (!deque.isEmpty()) {
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        if (layer == 0) {
          // at even layer, push from right to left
          TreeNode tmp = deque.pollLast();
          list.add(tmp.key);
          if (tmp.right != null) {
            deque.offerFirst(tmp.right);
          }
          if (tmp.left != null) {
            deque.offerFirst(tmp.left);
          }
        } else {
          // at odd level, from left to rights
          TreeNode tmp = deque.pollFirst();
          list.add(tmp.key);
          if (tmp.left != null) {
            deque.offerLast(tmp.left);
          }
          if (tmp.right != null) {
            deque.offerLast(tmp.right);
          }
        }
      }
      layer = 1 - layer;
    }
    return list;
  }
}
