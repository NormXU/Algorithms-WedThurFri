public class Solution {
  public void reverse(int[] array) {
    int start = 0;
    int end = array.length - 1
    while(start < end){
      swap(array, start, end);
      start++;
      end--
    }

  }

  private void swap(int[] array, int i, int j){
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;

  }
}
