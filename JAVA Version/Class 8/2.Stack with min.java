public class Solution {
  private Deque<Integer> in;
  private Deque<Integer> minStack;
  public Solution() {
    // write your solution here
    in = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }

  public int pop() {
    if(in.isEmpty()){
      return -1;
    }
    int t =  in.pop();
    if(t == minStack.peek()){
      minStack.pop();
    }
    return t;
  }

  public void push(int element) {
    in.push(element);
    if(minStack.isEmpty() || minStack.peek() >= element){
      minStack.push(element);
    }
  }

  public int top() {
    if(in.isEmpty()){
      return -1;
    }
    return in.peek();
  }

  public int min() {
    if(minStack.isEmpty()){
      return -1;
    }
    return minStack.peek();
  }
}
