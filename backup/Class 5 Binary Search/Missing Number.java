public class Solution {
  public int missing(int[] array) {
    // Write your solution here
    if(array.length == 0){
      return 1;
    }
    int N = array.length + 1;
    if(array[0] != 1){
      return 1;
    }
    if(array[array.length - 1] != N){
      return N;
    }
    int left = 0;
    int right = array.length - 1;
    int mid = 0;
    while(left + 1 < right){
      mid = left + (right - left) / 2;
      if( (array[left] - left) != (array[mid]-mid)){
        right = mid;
      }else if((array[right] - right) != (array[mid]-mid)){
        left = mid;
      }
    }
    return array[left] + 1;
  }
}
