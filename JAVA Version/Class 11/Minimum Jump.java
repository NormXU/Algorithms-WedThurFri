Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

Assumptions

The given array is not null and has length of at least 1.
Examples

{3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

{2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
=====================================================================================
M[i] 代表从0到i，从左往右跳的最小的次数
M[i] = -1表示跳不到
{3, 3, 1, 0, 4}
 0  1  2  2 -1
public class Solution {
  public int minJump(int[] array) {
    // Array is not null and is not empty
    int length = array.length();
    int[] minJump = new int[length];
    minJump[0] = 0; // the min number of jumps from 0 to each of the indices
    for (int i = 1;i < array.length ;i++ ) {
      minJump[i] = -1; // 先不知能不能跳到这里 initialize as unreachable
      for (int j = i-1; j>=0; j--) {
        if (array[j] >= i-j && minJump[j] != -1) {
          if (minJump[i] == -1 || minJump[i] > minJump[j]+1) {
            minJump[i] = minJump[j] + 1;
          }
        }

      }
    }
    return minJump[length-1];
  }
}
