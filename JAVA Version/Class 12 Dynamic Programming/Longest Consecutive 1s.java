public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    if (array.length == 0){
      return 0;
    }
    int[] M = new int[array.length];
    int result = array[0];
    if(array[0] > 0){
      M[0] = 1;
    } else {
      M[0] = 0;
    }
    for (int i = 1; i < array.length; i++) {
      if (array[i] > 0) {
        M[i] = M[i-1] + 1;
      } else {
        M[i] = 0;
      }
      result = Math.max(result, M[i]);
    }
    return result;
  }
}
