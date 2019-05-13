public class User{
  private final String firstName;
  private final String lastName;
  private int age;
  private String phone;
  private String address;

  private User(UserBuilder builder){
    this.firstName = builder.firstName;
    this.lastName  = builder.lastName;
    this.age       = builder.age;
    this.phone     = builder.phone;
    this.address   = builder.address;
  }

  public String getFirstName(){
    return firstName;
  }
  public String getLastName(){
    return lastName;
  }
  public String getAge(){
    return age;
  }
  public String getPhone(){
    return phone;
  }
  public String getAddress(){
    return address;
  }

// Nested Class
public static class UserBuilder{
  private String firstName;
  private String lastName;
  private int age = 0;
  private String phone = "";
  private String address;

  public UserBuilder firstName(String firstName){
    this.firstName = firstName;
    return this;
  }

  public UserBuilder lastName(String lastName){
    this.lastName = lastName;
    return this;
  }

  public UserBuilder firstName(int age){
    this.age = age;
    return this;
  }

  public UserBuilder firstName(String phone){
    this.phone = phone;
    return this;
  }

  public UserBuilder firstName(String address){
    this.address = address;
    return this;
  }
}
}


// 调用Demo程序
public static void main(String[] argv){
  User user = new User.UserBuilder().firstName("Sam");
                                    .lastName("Xu");
                                    .age(age);
                                    .phone("123-456-7890");
                                    .address("Fake address");
}
============================================================
这种做法将实现与builder分离了开来，从而使整个程序更加易于修改
