Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
================================================================================
package laioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	  public List<String> subSets(String set) {
	    // Write your solution here.
	    List<String> results = new ArrayList<>();
	    if (set == null) {
	      return results;
	    }
	    Set<String> allsets = new HashSet<>();
	    char[] arraySet = set.toCharArray();
	    StringBuilder sb = new StringBuilder();
	    Arrays.sort(arraySet);
	    helper(arraySet, sb, 0,  results, allsets);
	    return results;
	  }

	  private void helper(char[] set, StringBuilder sb, int index, List<String> results, Set<String> allsets){
	    if (index == set.length ) {
	      String tmp = sb.toString();
	      if (!allsets.contains(tmp)) {
	        results.add(tmp);
	        allsets.add(tmp);

	      }
	      return;
	    }

	    helper(set, sb.append(set[index]),  index+1,  results, allsets);
	    sb.deleteCharAt(sb.length()-1);

	    helper(set, sb, index+1, results,allsets);
	  }
	  public static void main(String[] args) {
		  Solution test = new Solution();
		  List<String> results = test.subSets("abab");
		  System.out.print(results);
	  }
	}
