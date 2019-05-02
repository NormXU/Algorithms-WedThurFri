public class Animal{
  public double weight;
  public double age;
  public String name;

  public double getWeight(){
    return weight;
  }

  public double getAge(){
    return age;
  }

  public String getName(){
    return name;
  }

  public void setWeight(){
    this.weight = weight;
  }

  public void setAge(){
    this.age = age;
  }

  public void setName(){
    this.name = name;
  }
}


public class Car extends Animal{

  @Override
  public String toString(){
    return "Cat [getWeight()=" + getWeight() + ", getAge()=" + getAge() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
  }
}


public interface IAnimal {
  String getName();
  double getAge();
  double getWeight();


}

public class Dog implements IAnimal {
  public double weight;
  public double age;
  public String name;

  @Override
  public double getWeight(){
    return weight;
  }

  @Override
  public double getAge(){
    return age;
  }

  @Override
  public String getName(){
    return name;
  }

  @Override
	public String toString() {
		return "Dog [weight=" + weight + ", age=" + age + ", name=" + name + "]";
	}

  public void setWeight(){
    this.weight = weight;
  }

  public void setAge(){
    this.age = age;
  }

  public void setName(){
    this.name = name;
  }

}
