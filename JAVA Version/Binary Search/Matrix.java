public int[] findIntMatrix(int[][] matrix, int target){
  int result = {-1, -1};
  if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return result;
  }
  int m = matrix.length;
  int n = matrix[0].length;
  int left = 0, right = m * n - 1;
  while(left <= right){
    int mid = left + (right - left) / 2;
    if (target == array[mid/n][mid%n]) {
      result[0] = mid / n;
      result[1] = mid % n;
      return result;
    } else if (target < matrix[mid/n][mid % n]) {
      right = mid - 1;
    } else{
      left = mid + 1;
    }
  }
}
