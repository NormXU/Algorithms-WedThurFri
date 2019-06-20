## Concurrency V.S Parallel

**Concurrency:**更多意味着multiple tasks run simultaneously，而且不知道事件发生的先后顺序

**Parallel：**在物理上multiple tasks run simultaneously. Implementation level concept

例如：multilane highway; multicore machines

Concurrency is in the program, parallel is in the actual execution. 即便是单核，多个事件也可以concurrency

eg： Event A is concurrent to Event B. 对于单核来说，先执行A执行一半，再执行B执行一半，然后再执行A的后半段



Multiprocess V.S multi-thread

Process: an independent execution of instruction with independent memory space, stack, heap and OS resource. Different processes communicates through interprocess communication.

virtual memory; Each process sees a complete memory (pretend to be the only task of the system, Different processes communicates through interprocess communication)

Thread: An independent execution of instructions with shared memory space

Thread in the same process has shared:heap, static memory segment, OS resource

Communication performed through shared memory read/writes



因此，process和thread的主要区别就在于他们是否有独立的memory space.



Java Thread

- create the threads objects

- tell the threads what you want them to do

- start the thread

  ```java
  Thread t = new Thread();
  t.start();
  t.join();
  
  class Thread{
      public void run(){};
      public void start(){
          // ....
          run();
          // Do What you Want To Do
      }
      public static void main(){
          Thread t = new Thread(){
              @Override
              public void run(){
                  System.out.print('Hello 1');
              }
              t.start();
              System.out.print('Hello 2');
              t.join();
              System.out.print('Hello 3');
          }
      }
  }
  ```

  

main --------new thread -------- print hello 2 ------- join -- print hello 3 ---- exit

​                        |                                                             |

​                        |                                                             |

​                         --------------------print hello 1 -------------

对于JVM来说，只有当所有线程都执行完毕后，整个JVM才会exit，这个叫做no alive-daemon threads

被重写的run()相当于new thread的main函数。

其他implementation的方法有：

```java
class HelloThread extends Thread{
    @Override
    public void run(){
        System.out.println('Hello');
    }
}
public static void main(String[] args){
    Thread newThread = new HelloThread();
    newThread.start();
}
```

```java
interface Runnable{
    void main();
}
class HelloRunnable extends Clients implements Runnable{
    @Override
    public void run(){
        // To Do What You Want
    }
}
public static void main(String[] args){
    Thread newThread = new Thread(new HelloRunnable());
    newThread.start();
}
```

Synchronization and Race

Synchronization 的主要作用是：Impose orders on previous concurrent event.

How?

- Locks (Synchronized)
- Concurrent data structures
- Wait/ Notify (Condition Synchronization )

If two conflicting operations are in different threads and they are not properly synchronized, they will introduce data races. Data Races are mostly treated as bugs in Java Programs. In general, two operations conflict with each other if they operate on the same memory locations and at least one of them is a write.

想要克服data races，只有给thread加锁



Critical Section: 

A part of a multi-process program that may not be concurrently executed by more than one of the program's process/threads。给进程加锁，相当于，必须加锁进程完成后，再去执行其他进程。就相当于排队上厕所，进入厕所隔间后，把门插上。只有当自己完事儿后，才会把锁打开，给后面的人使用。

```java
class Counter{
    private int value;
    public Counter(int value){
        this.value = value;
    }
    
    public void increase(){
        synchronized(this){
            value++;
        }
        // ... 
        System.out.println('hello');
    }
    
    public synchronized void decrease(){
        value--;
    }
    
    public synchronized int getCount(){
        return value;
    }
    
}
```

```java
// For Static Method in a class
class Counter{
    private static int value = 0;
    public static synchronized void increament(){
        value++;
    }
    public static synchronized void decrease(){
        synchronized(Counter.class){
            value--;
        }
    }
    public static int getCount(){
        synchronized(Counter.class){
            return value;
        }
    }
    
}
```



因此，synchronized on static/non-static methods

```java
synchronized on non-static method  == synchronized(this);
synchronized on static method      == synchronized(Counter.class)
要指定对哪一个类进行加锁
```





# Concurrency II

### HashMap Synchronization

在什么情况下会发生data race呢？

当我们对HashMap进行put，同时又对HashMap进行get的时候，会发生Data Race

put VS get, put V.S. put  --> data race free --> use lock(synchronized keyword) ---> whose lock

```java
public class MyHashMap<K, V>{
    static class Node<K, V>{
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value){
            this.key = key;
            this.value = value;
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
    }
    
    public static final int DEFAULT_CAPACITY = 16;
    public static final int DEFAULT_LOAD_FACTOR = 0.75f;
    
    private Node<K, V>[] array;
    private int size;
    private float loadFactor;
    
    MyHashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }
    MyHashMap(int cap, float loadFactor){
        if(cap <= 0){
            throw new IllegalArgumentException("cap cannot <= 0");
        }
        this.loadFactor = loadFactor;
        size = 0;
        array = (Node<K, V>[]) (new Node[cap]);
    }
    
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void clear(){
        Arrays.fill(array, null);
        size = 0;
    }
    private int hash(){
        if(key == null){
            return 0;
        }
        int code = key.hashCode();
        return code & 0x7FFFFFFF;
    }
    
    private int getIndex(int hash){
        return hash % array.length;
    }
    
    public boolean equalsKey(K k1, K k2){
        return k1 == k2 || (k1 != null && k1.equals(k2));
    }
    public V put(K key, V value){
        int index = getIndex(hash(key));
        Node<K, V> cur = array[index];
        while(cur != null){
            if(equalsKey(cur.key, key)){
                V result = cur.value;
                cur.value = value;
                return result;
            }
            cur = cur.next;
        }
        Node<K, V> newHead = new Node<>(key, value);
        newHead.next = array[index];
        array[index] = newHead;
        size++;
        if(needRehashing()){
            rehashing();
        }
        return null;
        
    }
    private boolean needRehashing(){
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }
    rehashing();
    get();
    containskey();
    
    public boolean equalsValue(V v1, V v2){
        return v1 == v2 || (v1 != null && v1.equalsl(v2));
    }
    
    public boolean containsValue(V value){
        
    }
    remove();
    
}
```

