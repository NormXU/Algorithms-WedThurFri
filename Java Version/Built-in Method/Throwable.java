import java.io.*;
public class Test {
  static void fun(){
    try {
      throw new NullPointerException("demo");
    } catch(NullPointerException e) {
      System.out.println("Caught inside fun()");
      throw e;
    }
  }

  public static void main(String args[]){
    try {
      fun();
    } catch(NullPointerException e) {
      System.out.println("Caught in the main");
    }
  }
}

======================= Throws ================================================
public class Test {
  static void fun() throws IllegalAccessException {
    throw new IllegalAccessException("demo");
  }

  public static void main(String[] args) {
    try {
      fun();
    } catch(IllegalAccessException e) {
      System.out.println("Caught in main");
    }
  }
}

===============================================================================
你可以让一个函数无限制的扔锅，但至少要在main这一层去处理这个锅，如果出现
public static void main(String[] args) throws IllegalAccessException {
  fun();
}
main 也去扔锅而不去处理这个锅，JAVA Program会被终止，Top Level Exception will be thrown
