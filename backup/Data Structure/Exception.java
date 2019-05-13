public class ExceptionTest {
  public static void execute() throws Exception {
    System.out.println("execute...");
    throw new Exception();
  }
}
================================================================================
// Throw Exception by ourselves
public class MyException extends Exception {
  public MyException() {
    super();
  }

  public MyException(String msg) {
    super(msg + " my exception ");
  }
}

public class ExcaptionTest {
  public static void execute(String a) throws MyException {
    System.out.println("execute...");
    if ("true".equals(a)) {
      throw new MyException("It can be true");
    }
  }
}
