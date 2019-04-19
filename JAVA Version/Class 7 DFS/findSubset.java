public class Solution{
  public List<String> subSets(String set){
    List<String> results = new ArrayLists<>();
    if (set == null) {
      return null;
    }
    char[] arraySet = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(arraySet, sb, 0, results);
    return results;
  }

  private void helper(char[] set, StringBuilder sb, int index, List<String> results){
    if (index == set.length) {
      result.add(sb.toString());
    }

    helper(set, sb.append(set[index]),  index+1,  results)
    sb.deleteCharAt(sb.length()-1);

    helper(set, sb, index+1, result);
  }
}
