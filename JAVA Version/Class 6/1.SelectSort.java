public class Test{
  public static void main(String[] args){
    int[] array = {9, 2, 5. 7};
    Solution sol = new Solution();
    sol.sort(array);
    for (int i: array ) {
      System.out.print(i + " ");
    }

  }

}

class Solution{
  public void sort(int[] array){
    if (array == null || array.length <= 1) {
      return;
    }
    for (int i = 0;i < array.length - 1 ;i++ ) {
      int minIndex = i;
      for (int j = i+1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          minIndex = j;
        }
      }
      swap(array, minIndex, i);
    }
  }

  private void swap(int[] array, int x, int y){
    int tmp = array[x];
    array[x] = array[y];
    array[y] = tmp;
  }
}
