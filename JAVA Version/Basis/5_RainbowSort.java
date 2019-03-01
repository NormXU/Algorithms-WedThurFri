/*
Examples

{0} is sorted to {0}
{1, 0} is sorted to {0, 1}
{1, 0, 1, -1, 0} is sorted to {-1, 0, 0, 1, 1}
*/

public class Solution {
  public int[] rainbowSort(int[] array) {
    // Write your solution here
    if(array == null || array.length <= 1){
      return array;
    }
    // Three boundaries
    // 1. the left side of neg is -1( not include neg) [0, i)
    // 2. the right side of neg is 1                   (k, n-1]
    // 3. between zero and one is unknow zone          [j, k]
    // 4. the part between neg and zero is 0           [i, j]
    int neg = 0;
    int one = array.length - 1;
    int zero = 0;
    while(zero <= one){
      if(array[zero] == -1){
        swap(array, neg, zero);
        neg++;
        zero++;
      }else if(array[zero] == 0){
        zero++;
      }else{
        swap(array, zero, one);
        one--;
      }
    }
    return array;
  }
   public void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

}

[[1,1,0,-1,0,1,-1]]
