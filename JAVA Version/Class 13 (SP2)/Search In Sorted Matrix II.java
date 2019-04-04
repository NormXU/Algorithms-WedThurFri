
Examples:

matrix = { {1, 2, 3}, {2, 4, 5}, {6, 8, 10} }

target = 5, return {1, 2}

target = 7, return {-1, -1}





public class Solution {
  public int[] search(int[][] matrix, int target) {
    // Write your solution here
    int[] results = {-1, -1};
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;
    int i = m;
    int j = 0;
    while(j <= n && i >= 0){
      if(matrix[i][j] == target){
        results[0] = i;
        results[1] = j;
        return results;
      }else if(matrix[i][j] > target){
        i--;
      }else{
        j++;
      }
    }
    return results;
  }
}
