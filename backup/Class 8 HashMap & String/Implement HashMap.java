public class MyHashMap<K, V>{

  public static class Node<K, V>{
    final K key;
    V value ;
    Node<K, V> next;

    Node<K key, V value>{
      this.key = key;
      this.value = value;
    }

  }

  public K getKey(){
    return key;
  }

  public V getValue(){
    return value;
  }

  public void setValue(V value){
    this.value = value;
  }

  public static final int DEFAULT_CAPACITY = 16;
  public static final float DEFAULT_LOAD_FACTOR = 0.75f;

  public MyHashMap(){
    this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
  }

  public MyHashMap(int cap, float loadFactor){
    if (cap <= 0) {
      throw new IllegalArgumentException("cap cannot < 0");
    }
    this.loadFactor = loadFactor;
    this.size = 0;
    this.array = (Node<K, V>[])(new Node[cap]);
  }

  public int size(){
    return size;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public void clear(){
    Array.fill(this.array, null);
    size = 0
  }

  private int hash(K key){
    // 1. null key
    if (key == null) {
      return 0;
    }

    int code = key.hashCode();
    return code >= 0 ? code: -code;
    // int range [-2^31, 2^31 - 1]
    // in case of stack overflow
    // -Integer.MIN_VALUE = Integer.MIN_VALUE

  }

  private int getIndex(K key){
    return hash(key) % array.length;
  }

  private boolean equalsValue(V v1, V v2){
    if (v1 == null && v2 == null) {
      return true;
    }
    if (v1 == null || v2 == null) {
      return false;
    }
    return v1.equals(v2);
  }

  public boolean containsKey(K key){
    int index = getIndex(key);
    Node<K, V> node = array[index];
    while (node != null) {
      if (equalsKey(node.key, key)) {
        return true;
      }
      node = node.next;
    }
  }

  public V get(K key){
    int index = getIndex(key);
    Node<K, V> node = array[index];
    while (node != null) {
      if (equalsValue(node.key, key)) {
        return node.value;
      }
      node = node.next;
    }
    return null;
  }

  public V put(K key, V value){
    int index = hashCode(key);
    Node<K, V> head = array[index];
    Node<K, V> node = head;
    while(node != null){
      if (equalsKey(node.key, key)) {
        V result = node.value;
        node.value = value;
        return result;
      }
      node = node.next;
    }
    Node<K, V> newNode = new Node(key, value);
    newNode.next = head;
    array[index] = newNode;
    size++;
    if (needRehashing()) {
      rehashing();
    }
    return null;
  }

}
