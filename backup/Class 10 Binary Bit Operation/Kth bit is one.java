Get x's K-th bit
(x >> k) & 1  == x's K-th bit

Set x's K-th bit to 1
x |= (1 << k)

Set x's K-th bit to 0
x &= ~(1 << k)


int countOnes(int n){
  int res = 0;
  while(n > 0){
    res += (n & 1);
    n = n >> 1
  }
  return res;
}

boolean isPowerOf(int n){
  return n > 0 && countOnes(n) == 1;
}

boolean isPowerOf(int n){
  return ((n & (n-1) == 0) && (n > 0));
}

int countDifferentBits(int a, int b){
  int count = 0;
  for (int c = a ^ b;c!=0 ;c = c >> 1 ) {
    count = count + (c & 1);
  }
}


whether contains unique characters

boolean[] hashset = new boolean[65536];
for (int i = 0;i < str.length() ;i++ ) {
  int ch = str.charAt(i);
  if (hashset[ch]) {
    return false;
  }
  hashset[ch] = true;
}
