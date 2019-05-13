Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T.
Examples

# 从中间开花
A = {1, 2, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
        L  R

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    // Write your solution here
    int left = largestSmall(array, target);
    int right = left + 1;
    int[] result = new int[k];
    for(int i = 0; i < k; i++){
      if(right >= array.length || left >= 0 && target - array[left] <= array[right] - target){
        result[i] = array[left];
        left--;
      }else{
        result[i] = array[right];
        right++;
      }
    }
    return result;
  }
  private int largestSmall(int[] array, int target){
    int left = 0;
    int right = array.length - 1;
    while(left + 1 < right){
      int mid = left + (right - left) / 2;
      if (array[mid] <= target){
        left = mid;
      }
      else{
        right = mid;
      }
    }
    if(array[right] <= target){
      return right;
    }
    if(array[left] <= target){
      return left;
    }
    return -1;
  }
}
