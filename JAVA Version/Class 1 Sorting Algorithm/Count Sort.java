public class Test{
  public static void main(String args[]){
    int[] arr = {3, 4, 7, 5, 6, 3, 4, 7, 5, 4};
    Solution sol = new Solution();
    sol.countSort(arr, 3, 7);
    for (int x : arr) {
      System.out.println(x + " ");
    }
  }
}


class Solution {
  public void countSort(int[] arr, int lower, int upper) {
    int[] count = new int[upper - lower + 1];
    for (int x : arr) {
      count[x - lower]++;
    }
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        arr[index] = lower + i;
        count[i]--;
        index++
      }
    }
  }
}
