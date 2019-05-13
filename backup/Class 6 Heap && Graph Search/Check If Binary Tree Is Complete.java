public class Solution{
  public boolean isComplete(TreeNode root){
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return true;
    }
    queue.offer(root);
    boolean flag = false;
    while(!queue.isEmpty()){
      TreeNode cur = queue.poll();
      if (cur.left == null) {
        flag = true;
      } else if(flag){
        return false;
      } else{
        queue.offer(cur.left);
      }

      if (cur.right == null) {
        flag = true;
      } else if(flag){
        return false;
      } else{
        queue.offer(cur.right);
      }

    }
    return true;
  }
}
