​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
================================================================================
public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    StringBuilder sb = new StringBuilder();
    char[] arrayChar = set.toCharArray();
    helper(arrayChar, 0, sb, result);
    return result;
  }

  private void helper(char[] arrayChar, int index, StringBuilder sb, List<String> result){
    if (index == arrayChar.length) {
      result.add(sb.toString());
      returnl
    }
    helper(arrayChar, index+1, sb.append(arrayChar[index]), result);
    sb.deleteCharAt(sb.length()-1);
    helper(arrayChar, index+1, sb, result);
  }
}
