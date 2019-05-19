The relative order of the elements in the original array need to be maintained.

Assumptions:

The given array is not null.
Examples:

{1} --> {1}
{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
================================================================================
public class Solution {
  public int[] moveZero(int[] array) {
    if(array.length <= 1){
      return array;
    }
    int end = 0;
    for(int i = 0; i < array.length; i++){
      if(array[i] != 0){
        array[end] = array[i];
        end++;
      }
    }
    for(int i = end; i < array.length; i++){
      array[i] = 0;
    }
    return array;
  }
}
