Given a sorted integer array, remove duplicate elements.
For each group of elements with the same value keep at most two of them.
Examples

{1, 2, 2, 3, 3, 3} → {1, 2, 2, 3, 3}

                s
                f
{1, 2, 2, 2, 3, 3} → {1, 2, 2, 3, 3}
          s
            f

initial
s = 2
f = 2

array[s-2] != array[f]
array[s] == array[f]
s++
f++

array[s-2] == array[f]
f++
================================================================================
public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length <= 2){
      return array;
    }
    int slow = 2;
    int fast = 2;
    while(fast < array.length){
      if(array[fast] != array[slow-2]){
        array[slow] = array[fast];
        fast++;
        slow++;
      }else{
        if(array[fast] == array[slow-2]){
          fast++;
        }
      }
    }
    return Arrays.copyOf(array,slow);
  }
}
