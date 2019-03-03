/*
Given a target integer T and an integer array A sorted in ascending order, find the index i such that A[i] == T or return -1 if there is no such index.

A = {1, 2, 3, 4, 5}, T = 3, return 2
A = {1, 2, 3, 4, 5}, T = 6, return -1
A = {1, 2, 2, 2, 3, 4}, T = 2, return 1 or 2 or 3

*/
public class Solution {
  public int binarySearch(int[] array, int target) {
    // Write your solution here
    if(array == null || array.length == 0){
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while(left+1 < right){
      int mid = left + (right - left) / 2;
      if(array[mid] == target){
        return mid;
      }
      if(array[mid] > target){
        right = mid;
      }else{
        left = mid;
      }
    }
    if(array[left] == target){
      return left;
    }
    if(array[right] == target){
      return right;
    }
    return -1;
  }
}
