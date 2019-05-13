​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
=================================================================================

public class Solution {
  public List<String> subSet(String set){
  List<String> result = new ArrayList<>();
  if (set == null) {
    return result;
  }
  Set<String> allset = new HashSet<>();
  char[] arraySet = set.toCharArray();
  StringBuilder sb = new StringBuilder();
  Arrays.sort(arraySet);
  helper(arraySet, sb, 0, result, allset);
  return result
  }

  private void helper(char[] set, StringBuilder sb, List<String> result, Set<String> allset){
    if (index == set.length) {
      String tmp = sb.toString();
      if (!allset.contains(tmp)) {
        result.add(tmp);
        allset.add(tmp);
      }
      return;
    }

    helper(set, sb.append(set[index]), index+1, result, allset);
    sb.deleteCharAt(sb.length()-1);
    helper(set, sb, index+1, result, allset);
  }
}
