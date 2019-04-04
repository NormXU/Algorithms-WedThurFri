How to find the smallest element that is larger than a target number

input[N] = {1,3,4,5,8,9}
target   = 7
return 8

int binarySearch(int[] a, int left, int right, int target){
  while(left+1 < right){
    int mid = left + (right - left) / 2;
    if (a[mid] == target) {
      left = mid;
    }
    else if ( a[mid] < target) {
      left = mid;
    }
    else{
      right = mid;
    }
  }
  if (a[left] > target) {
    return left;
  }
  if (a[right] > target) {
    return right;
  }
  return -1;

}
