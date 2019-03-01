/*Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

Examples

power(2, 0) = 1
power(2, 3) = 8
power(0, 10) = 0
power(-2, 5) = -32
*/

时间复杂度为O(n)

public class Solution{
  public long power(int a, int b){
    if (a == 1) {
      return 1;
    }
    if (b == 0) {
      return 1;
    }
    if (a == 0) {
      return 1;
    }
    long half = power(a, b/2);
    if (b%2 == 0) {
      return half * half;

    }else{
      return half * half * a;
    }
  }
}
