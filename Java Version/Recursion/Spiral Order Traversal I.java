{ {1,  2,  3},

  {4,  5,  6},

  {7,  8,  9} }

the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]

public class SpiralTraversal {
  public List<Integer> spiral(int[][] matrix){
    List<Integer> list = new ArrayList<Integer>();
    recursiveTraversal(matrix, 0, matrix.length, list);
    return list;
  }

  private void recursiveTraversal(int[][] matrix, int offset, int size, List<Integer> result){
    if (size == 0) {
      return;
    }
    if (size == 1) {
      result.add(matrix[offset][offset]);
      return;
    }
    for (int i = 0; i < size - 1; i++) {
      result.add(matrix[offset][offset+i]);
    }
    for (int i = 0; i < size - 1; i++) {
      result.add(matrix[offset+i][offset+size-1]);
    }
    for (int i = size - 1; i >= 1; i--) {
      result.add(matrix[offset+size-1][offset+i]);
    }
    for (int i = size-1; i>=1; i--) {
      result.add(matrix[offset+i][offset]);
    }
    recursiveTraversal(matrix, offset+1, size-2,result);
  }
}
