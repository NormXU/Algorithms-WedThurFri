public class Singleton {
  private static final Singleton INSTANCE = new Singleton();

  private Singleton(){};

  public static Singleton getInstance(){
    return INSTANCE;
  }
}


把构造函数设为private， 只用getInstance()来获得这个实例
