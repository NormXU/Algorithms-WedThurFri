class MinStack{
  public MinStack(){
    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> miniStack = new LinkedList<>();

  }

  public void push(int value){
    stack.offerFirst(value);
    if (miniStack.isEmpty() || miniStack.peek() > value) {
      miniStack.offerFirst(value);
    }

  }
  public Integer pop(){
    if (stack.isEmpty()) {
      return null;
    }
    int t = stack.pollFirst();
    if (t == miniStack.peek()) {
      miniStack.pollFirst();
    }
    return t;

  }
  public Integer getMin(){
    if (miniStack.isEmpty()) {
      return null;
    }
    return miniStack.peek();
  }
}

================================================================================
[ 8 2 9 3
[
[ 1
int tmp = 1

public Deque<Integer> sort(Deque<Integer> s1, Deque<Integer> s2, Deque<Integer> s3){
  if (s1.isEmpty()) {
    return s1;
  }
  int length = s1.size();
  int globalMin = Integer.max;
  while(!s1.isEmpty){
    int tmp = s1.pollFirst();
    if (tmp < globalMin) {
      globalMin = tmp;
    }
    s2.offerFirst(tmp);
  }
  s3.offerFirst(globalMin);
  while(!s2.isEmpty()){
    int tmp = s2.pollFirst();
    if (tmp > s3.peek()) {
      
    }
  }




}
