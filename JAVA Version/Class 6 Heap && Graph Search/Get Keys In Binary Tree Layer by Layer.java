public class Solution{
  public List<List<Integer>> layerByLayer(TreeNode root){
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    if (root == null) {
      return results;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int length = queue.size();
      List<Integer> curLayer = new ArrayList<>();
      for (int i = 0;i < length ;i++ ) {
        TreeNode cur = queue.poll();
        curLayer.add(cur.key);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      results.add(curLayer);
    }
    return results;
  }
}


public class Solution2{
  public List<Integer> bfs(TreeNode root){
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){

      int nNode = queue.size();
      for (int i = 0;i < nNode ;i++ ) {
        TreeNode cur = queue.poll();
        result.add(cur.key);
        if (cur.left != null) {
          queue.offer();
        }
        if (cur.right != null) {
          queue.offer();
        }

      }

    }
    return result;
  }
}
