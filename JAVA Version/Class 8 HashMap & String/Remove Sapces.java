_ _ I _ _ _ Love MIT
    i
            j


public class Solution {
  public String removeSpaces(String input) {
    if (input.isEmpty()) {
      return input;
    }
    char[] array = input.toCharArray();
    for (int j = 0;j < array.length ;j++ ) {
      if (array[j] == 0 && (j == 0 || array[j-1] = ' ')) {
        continue;
      }
      array[end] = array[j];
      end += 1;
    }
    if (end > 0 && array[end - 1] == ' ') {
      return new String(array, 0, end-1);
    }
    return new String(array, 0, end);
  }
}
