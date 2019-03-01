/*
Assuming a stair has n stes. There are two ways for a human to walk. 1 step or 2 step at once. How many different ways to walk over n steps?

*/
方法1， Memory 法，可以少算Binary Tree的一边，然后把复杂度从O(2^n) 降到 O(n)

public class Fibonacci{

long fibo(int n){
  if(n == 0){
    return 0;
  } else if (n == 1) {
    return 1;
  }
  if(cache[n - 1] == -1){
    cache[n - 1] = fibo(n - 1, cache);
  }
  if(cache[n - 2] == -1){
    cache[n - 2] = fibo(n - 2, cache);
  }
  return cache[n - 1] + cache[n - 2];
}

public static void main(String[] args) {
  int[] cache = new int[n];
  System.out.println(fibo(n, cache));
}
}



方法2， 这个复杂度甚至可以降到O(1)
public class Fibonacci{

long fibo(int n){
  int a = 0;
  int b = 1;

  while (n >= 0) {
    int tmp = a;
    int a = b;
    int b = tmp + b;
    n -= 1;

  }
  return b;

}
}
