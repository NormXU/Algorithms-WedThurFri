For each group of elements with the same value do not keep any of them.
Examples

{1, 2, 2, 3} → {1}
    e
          f

2 4 5 3 3 4 5 5 5
    e
                f

initial:
e = 1
f = 1
flag = 1

array[f-1] != array[f]
array[e] = array[f]
f++
e++
flag = 0

array[f-1] == array[f] and flag == 0
e--
f++
flag = 1

array[f-1] == array[f] and flag == 1
f++


public class Solution {
  public int[] dedup(int[] array) {
    // Write your solution here
    if(array.length <= 1){
      return array;
    }
    int end = 1;
    int fast = 1;
    boolean flag = false;
    while(fast < array.length){
      if(array[fast-1] != array[fast]){
        array[end] = array[fast];
        fast++;
        end++;
        flag = false;
      } else{
        if(array[fast-1] == array[fast] && flag == false){
          end--;
          fast++;
          flag = true;
        }else if(array[fast-1] == array[fast] && flag == true){
          fast++;
        }
      }
    }
    return Arrays.copyOf(array, end);
  }
}
