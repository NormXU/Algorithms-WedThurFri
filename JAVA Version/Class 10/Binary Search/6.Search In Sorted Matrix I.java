/*
Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.
matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }

target = 7, return {1, 2}

target = 6, return {-1, -1} to represent the target number does not exist in the matrix.
*/
public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here
    int[] res = {-1,-1};
    int left = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int right = m*n - 1;
    while(left+1 < right){
      int mid = left + (right - left) / 2;
      if(target == matrix[mid/n][mid%n]){
        res[0] = mid / n;
        res[1] = mid % n;
        return res;
      }
      else if(target < matrix[mid/n][mid%n]){
        right = mid;
      }
      else{
        left = mid;
      }

    }
    if(target == matrix[left/n][left%n]){
      res[0] = left / n;
      res[1] = left % n;
      return res;
    }
    if(target == matrix[right/n][right%n]){
      res[0] = right / n;
      res[1] = right % n;
      return res;
    }
    return res;
  }
}
