public class Solution {
  public List<List<Integer>> nqueens(int n) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur          = new ArrayList<>();
    helper(n, cur, result);
    return result;
  }

  private void helper(int n, List<Integer> cur, List<List<Integer>> result){
    if(cur.size() == n){
      result.add(new ArrayList<Integer>(cur));
      return;
    }
    for(int i = 0; i < n; i++) {
      if(valid(cur, i)){
        cur.add(i);
        helper(n, cur, result);
        cur.remove(cur.size()-1);
      }
    }
  }

  private boolean valid(List<Integer> cur, int col){
  int row = cur.size();
  for (int i = 0;i < row ;i++ ) {
    if (cur.get(i) == col || Math.abs(cur.get(i) - col)== row - i) {
      return false;
    }
  }
  return true;
 }

}

Q0              put(0,0)                           put(0,1)          put(0,2)         put(0,3)
          /     |     |       \
Q1 put(1,0) put(1,1) put(1,2) put(1,3)
然后再去除掉那些不满足的点
