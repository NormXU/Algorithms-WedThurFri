Abstract Factory
// 主要设计哲学：把实现和object recreation分离开来
public interface Shape{
  void draw(int size);
}

public class Rectangle implements Shape{}
public class Square implements Shape{}
public class Circle implements Shape{}

public class ShapeFactory {
  public Shape getShape(String shapeType){
    if (shapeType == null) {
      return null;
    }

    if (shapeType.equalsIgnoreCase("Circle")) {
      return new Circle();
    }

    if (shapeType.equalsIgnoreCase("Rectangle")) {
      return new Rectangle();
    }

    if (shapeType.equalsIgnoreCase("Square")) {
      return new Square();
    }

    return null;

  }
}


public class FactoryDemo{
  private final ShapeFactory shape_fact = new ShapeFactory();

  public void demo(String[] args){
    Shape shape1 = shape_fact.getShape("Circle");
    shape1.draw(1);

    Shape shape1 = shape_fact.getShape("Rectangle");
    shape1.draw(1);


  }
}
