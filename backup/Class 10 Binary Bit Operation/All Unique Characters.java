Determine if the characters of a given string are all unique.

For ASCII encoding, the number of valid letters is 256. encoded from 0 to 256

vector[0] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  0-31
vector[1] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  32-63
vector[2] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  64-95
vector[3] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  ....
vector[4] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X
vector[5] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X
...
vector[7] X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X  X X X X

每一个都只看最后4位，相当于有8个4位（8个 Integer）

public class Solution {
  public boolean allUnique(String word) {
    // Write your solution here
    int[] vec = new int[8];
    char[] array = word.toCharArray();
    for(char c : array){
      int row = c / 32;
      int col = c % 32;
      int weight = (1 << col);
      if((vec[row] & weight) != 0){
        return false;
      }
      vec[row] = vec[row] | weight;
    }
    return true;
  }

}
