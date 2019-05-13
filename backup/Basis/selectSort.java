public class Solution {
  public int[] solve(int[] array) {
    // Write your solution here
    if(array == null || array.length <= 1){
      return array;
    }

    for(int idx = 0; idx < array.length - 1; idx++){
      int minIdx = idx;
      for(int j = idx; j < array.length; j++){
        if(array[minIdx] > array[j]){
          minIdx = j;
        }
      }
      swap(array, idx, minIdx);
    }

    return array;
  }

  private void swap(int[] array, int i, int minIdx){
    int tmp = array[i];
    array[i] = array[minIdx];
    array[minIdx] = tmp;
  }
}
