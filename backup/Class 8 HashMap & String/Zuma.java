"abbbaaccz" → "aaaccz" → "ccz" → "z"

-1 z b b b a a c c z
   e
     i

public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    int end = 0
    for (int i = 1;i< array.length ; i++) {
      if ( end == -1 || array[i] != array[end]) {
        end++;
        array[end] = array[i];
      } else{
        end--;
        while (i+1 < array.length && array[i] != array[i+1]) {
          i++;
        }
      }
    }

    return new String(array, 0, end+1);
  }
}
