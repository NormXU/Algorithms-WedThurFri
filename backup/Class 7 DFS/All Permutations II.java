public class Permutation{
  public List<String> Permutation(String set){
    List<String> result = new ArrayList<>();
    if (set == null) {
      return result;
    }
    char[] array = set.toCharArray();
    helper(array, 0, result);
    return result;
  }

  private void helper(char[] array, int index, List<String> result){
    if (index == array.length) {
      result.add(new String(array));
      return;
    }
    Set<Character> used = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      // used.add will return false if the value of array[i]
      // is already in the Set.
      if (used.add(array[i])) {
        swap(array, i, index);
        helper(array, index+1, result);
        swap(array, i, index);
      }
    }
  }
}
