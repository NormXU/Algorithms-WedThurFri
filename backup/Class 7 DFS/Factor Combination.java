public class Solution {
  public List<List<Integer>> combinations(int target) {
    // Write your solution here
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list         = new ArrayList<>();
    helper(2,1,target,result, list);
    return result;
  }
  private void helper(int start, int product, int n, List<List<Integer>> result,  List<Integer> list){
    if (start > n || product > n){
      return;
    }
    if (product == n) {
      result.add(new ArrayList<>(list));
    }
    for(int i = start; i < n; i++){
      if(i*product>n)
        break;
      if(n%i == 0){
        list.add(i);
        helper(i, i*product, n, result, list);
        list.remove(list.size()-1);
      }
    }
  }
}
