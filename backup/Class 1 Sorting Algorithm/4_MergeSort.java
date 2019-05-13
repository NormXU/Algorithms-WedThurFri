public class Solution {
  public int[] mergeSort(int[] array) {
    // Write your solution here
    if(array == null || array.length <= 1){
      return array;
    }
    int start = 0;
    int end = array.length - 1;
    int[] helper = new int[array.length];
    mergeSort(array, start, end, helper);
    return array;
  }
  private void mergeSort(int[] array, int start, int end, int[] helper){
    if(start >= end){
      return;
    }
    int mid = start + (end - start) / 2;
    mergeSort(array, start, mid, helper );
    mergeSort(array, mid+1, end, helper );


    for(int ii = start; ii <= end; ii++){
      helper[ii] = array[ii];
    }

    int i = start;
    int idx = start;
    int j = mid+1;

    while(i <= mid && j <= end){
      if(helper[i] <= helper[j]){
        array[idx] = helper[i];
        i++;
      }
      else{
        array[idx] = helper[j];
        j++;
      }
      idx++;
    }

    while(i <= mid){
      array[idx] = helper[i];
      i++;
      idx++;
    }


  }
}
