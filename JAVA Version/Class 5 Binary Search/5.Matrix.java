Given a matrix, find the Kth index element.

example:

matrix:

1 3 4

5 6 7

8 9 10


k = 4 → return: 6

在二维矩阵下，寻找横、纵坐标，需要同 col 进行比较

public class Solution {
  public int findElement(int[][] matrix, int k) {
    int row = matrix.length;
    int col = matrix[0].length;
    int x = k / col;
    int y = k % col;
    return matrix[x][y];
  }
}
