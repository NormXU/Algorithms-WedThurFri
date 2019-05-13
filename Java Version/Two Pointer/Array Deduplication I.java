Assumptions

The array is not null
Examples

{1, 2, 3, 3, 3, 3} → {1, 2, 3}
          s
                f


initial:
s = 1
f = 1

array[f] != array[s-1]:
array[s] = array[f]
s++
f++

array[f] == array[s-1]:
f++
===============================================================================
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length <= 1){
      return array;
    }
    int slow = 1;
    int fast = 1;
    while(fast < array.length){
      if(array[fast] != array[slow-1]){
        array[slow] = array[fast];
        fast++;
        slow++;
      }else{
        if(array[fast] == array[slow-1]){
          fast++;
        }
      }
    }
    return Arrays.copyOf(array,slow);
  }
}
