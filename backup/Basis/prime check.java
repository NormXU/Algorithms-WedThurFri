import java.util.*;

public class Test{
  public static void main(String[] args) {

  }

  public static void checkG(int limit){
    for (int i = 4; i <= limit; i += 2) {
      if (canDivide(i)){
        System.out.println(i + "can be divided into two primes. ");
      }
      else{
        System.out.println("Success ! one counter-example");
        break;
      }
    }
  }


  private static boolean canDivide(int n){
    for (int i = 2; i <= n/2; i ++){
      if (isPrime(i) && isPrime(n - i)){
        return true;
      }
    }
    return false;
  }

  private static isPrime(int n){
    if (n < 2){
      return false;
    }
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0){
        return false;
      }
    }
    return true;
  }
}
