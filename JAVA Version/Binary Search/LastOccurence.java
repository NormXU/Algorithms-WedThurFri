public int lastOccurence(int[] array, int target){
  if (array == null || array.length == 0) {
    return -1;
  }
  int left = 0;
  int right = array.length - 1;
  while (left+1 < right) {
    int mid = left + (right - left)/2;
    if (array[mid] == target) {
      left = mid;

    } else if (array[mid] < target) {
      left = mid;

    } else  {
      right = mid;

    }

  }
  if (array[right] == target) {
    return right;

  }
  if (array[left] == target) {
    return left;

  }
  return -1;
}
