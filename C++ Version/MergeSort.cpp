void mergeSort(int* a, int left, int right){
  if (left < right) {
    int mid = left + (right - left) / 2;
    mergeSort(a, left, mid);
    mergeSort(a, mid+1, right);
    merge(a, left, right, mid);
  }
}

void merge(int* a, int left, int right, int mid){
  int sorted[right-left+1];
  int i = left, j = mid+1;
  int idx = 0;
  while (i<=mid && j<=right) {
    if (a[i] < a[j]) {
      sorted[idx] = a[i];
      idx += 1;
      i += 1;
    }
    else{
      sorted[idx] = a[j];
      j += 1;
      idx += 1;
    }
  }

  while (i<= mid) {
    sorted[idx] = a[i];
    idx += 1;
    i += 1;
  }
  while (j<= right) {
    sorted[idx] = a[j];
    idx += 1;
    j += 1;
  }
  for (int i = left, q = 0; i <= right; i++, q++) {
    a[i] = sorted[q];
  }

}
