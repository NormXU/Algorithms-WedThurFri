Determine whether a string contains unique characters
abcd  ==> True
abcda ==> False

public boolean uniquqChar(String a){
  int occuredCharacters = 0;
  for (int i = 0;i < a.length ;i++ ) {
    int k = a.charAt(i) - 'a';
    if ((occuredCharacters >> k) & 1 == 1) {
      return false;
    }
    occuredCharacters |= (1 << k);
  }
  return true;
}
