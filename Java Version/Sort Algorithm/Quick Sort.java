public Solution{
  public int[] quickSort(int[] array){
    if (array == null) {
      return array;
    }
    quickSort(array, 0, array.length - 1);
    return array;
  }

  public void quickSort(int[] array, int left, int right){
    if (left >= right) {
      return;
    }
    int pivotIdx = partition(array, left, right);
    quickSort(array, left, pivotIdx-1);
    quickSort(array, pivotIdx+1, right);
  }

  private int partition(int[] array, int left, int right){
    int pivotIdx = left + (int)(Math.random()*(right - left));
    int pivot    = array[pivotIdx];
    swap(array, pivotIdx, right);
    int leftBound = left;
    int rightBound = right - 1;
    while (leftBound <= rightBound) {
      if (array[leftBound] < pivot) {
        leftBound++;
      } else{
        swap(array, leftBound, rightBound);
        rightBound--;
      }
    }
    swap(array, leftBound, right);
    return leftBound;
  }
}
