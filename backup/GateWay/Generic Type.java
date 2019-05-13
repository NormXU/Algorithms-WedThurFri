Example 1
public class Test{
  public static <E> void printArray(E[] inputArray){
    for (E element : inputArray ) {
      System.out.println(element.toString() + ", ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] inputArray = {1,2,3,4,5};
    Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};

    printArray(inputArray);
    printArray(doubleArray);
  }
}
================================================================================
Example 2
public class MyPair <K, V>{
  private K key;
  private V value;

  public MyPair(K key, V value){
    this.key = key;
    this.value = value;
  }
  public K getKey(){return key};
  public V getValue(){return value};
}

public class Util{
  public static <K, V> boolean myequal(MyPair<K, V> p1, MyPair<K, V> p2){
    return p1.getKey().equals(p2.getKey()) &&
           p1.getValue().equals(p2.getValue());
  }
}
================================================================================
public class Test{
  public static <A, B, C> void printAll(A[] arr, List<B> list, Queue<C> queue){
    for (A a : arr ) {
      System.out.println(a);
    }
    System.out.println();
    for (int i = 0; i < list.size(); i++) {
      B b = list.get(i);
      System.out.println(b);
    }
    System.out.println();
    while (!queue.isEmpty()) {
      C c = queue.poll();
      System.out.println(c);
    }
  }
}
================================================================================
public class Test{
  public static < E extends Comparable<E> > E getMin(E[] arr){
    E min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      min = arr[i].compareTo(min) < 0 ? arr[i] : min;
    }
  }
}
