void quickSort(int* a, int left, int right) {
  if (left >= right) {
    return;
  }
  int pivot = left + (right - left) / 2;
  int index = left;
  swap(&a[pivot], &a[right]);
  for (int i = left; i < right; i++) {
    if (a[i] < a[right]) {
      swap(&a[index], &a[i]);
      index++;
    }
  }
  swap(&a[index], &a[right]);
  quickSort(a, left, index - 1);
  quickSort(a, index+1, right);
}

void swap(int* a, int* b){
  int temp;
  temp = *b;
  *b   = *a;
  *a   = temp;
}
