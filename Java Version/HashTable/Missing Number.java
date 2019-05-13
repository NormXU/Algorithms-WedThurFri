Examples

A = {2, 1, 4}, the missing number is 3
A = {1, 2, 3}, the missing number is 4
A = {}, the missing number is 1

public class Solution {
  public int missing(int[] array){
    if (array.length == 1) {
      return 1;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      Integer value = map.get(array[i]);
      if (value == null) {
        map.put(array[i], i);
      } else {
        map.put(array[i], value+1);
      }
    }
    int i;
    for (i = 1; i <= array.length+1; i++) {
      Integer value = map.get(i);
      if (value == null) {
        break;
      }
    }
    return i;
  }
}
