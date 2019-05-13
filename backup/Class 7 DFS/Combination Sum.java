Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums toT. The same repeated number may be chosen from C unlimited number of times.

All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order.

The solution set must not contain duplicate combinations.

Example

          given candidate set 2,3,6,7 and target 7,

    A solution set is:

     [7]

     [2, 2, 3]


 public class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
 		    // Write your solution here
 		    List<List<Integer>> result = new LinkedList<>();
 		    List<Integer> tmp          = new LinkedList<>();
 		    if(target < 0){
 		      return result;
 		    }
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
 		  for(int i = index; i < candidates.length;i++){
 			  tmp.add(candidates[i]);
 			  helper(sum + candidates[i], result, tmp, candidates, target, i);
 			  tmp.remove(tmp.size()-1);
 		  }
 	  }
 }
