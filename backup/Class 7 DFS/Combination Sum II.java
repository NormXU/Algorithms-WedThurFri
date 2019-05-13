package laioffer;


import java.util.*;
import java.util.Arrays;


public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		    // Write your solution here
		    List<List<Integer>> result = new LinkedList<>();
		    List<Integer> tmp          = new LinkedList<>();
		    if(target < 0){
		      return result;
		    }
		    Arrays.sort(candidates);
		    helper(0, result, tmp, candidates, target, 0);
		    return result;

	  }

	  private void helper(int sum, List<List<Integer>> result, List<Integer> tmp, int[] candidates, int target, int index) {
		  if(sum == target) {
			  result.add(new LinkedList<>(tmp));
			  return;
		  }
		  if(sum > target) {
			  return;
		  }
		  int prev = -1;
		  for(int i = index; i < candidates.length;i++){
			  if(prev != candidates[i]) {
				  tmp.add(candidates[i]);
				  helper(sum + candidates[i], result, tmp, candidates, target, i+1);
				  tmp.remove(tmp.size()-1);
				  prev = candidates[i];
			  }
		  }
	  }
	  public static void main(String[] args) {
		  Solution test = new Solution();
		  int[] cad = new int[]{ 10,1,2,7,6,1,5};
		  List<List<Integer>> result = test.combinationSum(cad, 8);

	  }
}
