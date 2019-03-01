// Time: O(log n )
// Space: O(1)



public int firstOccurence(int[] array, int target){
  if (array == null || array.length == 0) {
    return -1;
  }
  int left = 0, right = array.length - 1;
  while (left+1 < right) {
    int mid = left + (right - left) / 2;
    if (target == array[mid]) {
      right = mid;
    } else if (target > array[mid]) {
      left = mid;
    } else{
      right = mid;
    }
    if (target == array[left]) {
      return left;
    }
    if (target == array[right]) {
      return right;

    }
    return - 1;

  }
}
