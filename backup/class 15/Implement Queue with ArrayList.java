public class BoundedQueue{
  int head;
  int tail;
  int size;
  Integer[] array;
  public BoundedQueue(int cap){
    array = new Integer[cap];
    head = 0;
    tail = 0;
    size = 0；
  }
  public boolean offer(Integer element){
    if (size == array.length) {
      return false;
    }
    array[tail] = element;
    tail = tail + 1;
    if (tail == array.length) {
      tail = 0;
    }
    size++;
    return true;
  }
  public Integer peek(){
    if (size == 0) {
      return null;
    }
    Integer result = array[head];
    head = head + 1;
    if (head == array.length) {
      head = 0;
    }
    size--
    return result;
  }
}
