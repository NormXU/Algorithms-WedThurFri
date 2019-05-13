public class Solution{
  public long fibonacci(int K){
    long a = 0;
    long b = 1
    if(K <= 0){
      return 0;
    }
    while( K > 1){
      long tmp = a + b;
      a = b;
      b = tmp;
      K--;
    }
    return b;
  }
}
