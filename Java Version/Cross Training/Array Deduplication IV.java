Given an unsorted integer array, remove adjacent duplicate elements repeatedly,
from left to right. For each group of elements with the same value do not keep any of them.

Examples

{1, 2, 3, 3, 3, 2, 2} → {1, 2, 2, 2} → {1}, return {1}

public class Solution {
  public int[] dedup(int[] array) {
    int end = -1;
    for (int i = 0; i < array.length; i++) {
      if (end == -1 || array[end] != array[i]) {
        end++;
        array[end] = array[i];
      } else{
        while (i + 1 < array.length && array[i+1] == array[end]) {
          i++;
        }
        end--;
      }
    }
    return Arrays.copyOf(array, end + 1);
  }
}
-1 0  1  2  3  4  5  6
-------------------------
   1  2  2  3  3  3  2  2
                        i
   e
