class Solution {
  public void countSort(int[] arr, int lower, int upper){
    int[] count = new int[upper - lower + 1];
    for(int x : arr){
      count[x - lower]++;
    }
    int indx = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        arr[indx] = lower + i;
        indx++;
        count[i]--;
      }
    }
  }
}
