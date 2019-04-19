int swap(int x, int i, int j){
  // b7 0 b5 b4 b3 b2 0 b0
  // i = 6; j = 1
  //  0 1 0  0  0  0  1  0
  //  (0 1 0  0  0  0  0  0) + (0 0 0 0 0 0 1 0)
  //
  int bi = (x >> i) & 1;
  int bj = (x >> j) & 1;
  if (bi == bj) {
    return x;
  }
  x = x ^ ((1 << i) | (1 << j));

  return x;
}

int reverse(int x){
  int i = 0;
  int j = 31;
  while(i < j){
    x = swap(x, i, j);
    i++;
    j--;
  }
  return x;
}
