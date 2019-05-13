subprobelm:
  a^{b}   = a^{b/2} * a^{b/2}

recursion rule:
  if b 是偶数:
    a^{b} = half * half
  if b 是奇数:
    a^{b} = half * half * a

  base case:
    a = 1  return 1
    a = 0  return 1
    b = 0  return 1


public class Solution {
  public long power(int a, int b) {
    // Write your solution here
    if(a == 0){
      return 1;
    }
    if(b == 0){
      return 1;
    }
    if(a == 1){
      return 1;
    }
    long half = power(a, b/2);
    if(b%2 == 0){
      return half * half;
    }
    else{
      return half * half * a;
    }
  }
}

public class Solution2 {
  public long helper(int a, int b){
    if (b < 0) {
      return 1 / (double)power(a, -b);
    } else {
      return power(a, b);
    }
  }
  public long power(int a, int b) {
    // Write your solution here
    if(a == 0){
      return 1;
    }
    if(b == 0){
      return 1;
    }
    if(a == 1){
      return 1;
    }
    long half = power(a, b/2);
    if(b%2 == 0){
      return half * half;
    }
    else{
      return half * half * a;
    }
  }
}
