GUI elements creation complexxities
1) different elements
2) different styles
3) elements need to be consistent on styles
4) load button image from files
================================================================================
格式工厂
public interface GUIFactory {
  public Button createButton();
  public Border createBorder();
}

class WinFactory implements GUIFactory{
  public Button createButton(){
    return new WindowsButton();
  }

  public Border createBorder(){
    return new WindowsBorder();
  }
}

class OSXFactory implements GUIFactory{
  public Button createButton(){
    return new MacButton();
  }

  public Border createBorder(){
    return new MacBorder();
  }
}

=============================================================================
业务代码
class Application {
  private final GUIFactory factory;

  Application(GUIFactory f){
    this.factory = f;
  }

  void run(){
    Button button = factory.createButton();
    button.paint()
    Border border = factory.createBorder();
    border.paint()
  }
}

public static void main(String[] args) {
  factory = Construct a WinFactory
  Application app = new Application(factory);
  app.run
}
