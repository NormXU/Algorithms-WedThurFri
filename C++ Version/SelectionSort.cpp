void swap(int& a, int& b){
  int temp = a;
  a = b;
  b = temp;
}

void selectionSort(vector<int>& a) {
  if (a.size() == 0) {
    return;
  }
  int len = a.size();
  for(int i = 0; i < len - 1; i++){
    int min_idx = i;
    int min = a[i];
    for(int j = i + 1; j < len; j++){
      if (a[j] < min) {
        min = a[j];
        min_idx = j;
      }
    }
    swap(a[i],a[min_idx]);
  }
}
