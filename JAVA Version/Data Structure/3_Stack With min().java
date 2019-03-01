"""
Enhance the stack implementation to support min() operation. min() should return the current minimum value in the stack. If the stack is empty, min() should return -1.

pop() - remove and return the top element, if the stack is empty, return -1

push(int element) - push the element to top
top() - return the top element without remove it, if the stack is empty, return -1
min() - return the current min value in the stack.
"""
public class Solution{
  private Deque<Integer> in;
  private Deque<Integer> minStack;

  public Solution(){
    in = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }

  public int pop(){
    if (in.isEmpty()) {
      return -1;
    }
    int tmp = in.pop();
    if (tmp == minStack.peek()) {
      minStack.pop();
    }
    return tmp;
  }

  public void push(int element){
    in.push(element);
    if(minStack.isEmpty() || minStack.peek() >= element){
      minStack.push(element);
    }
  }

  public int top(){
    if(in.isEmpty()){
      return -1;
    }
    return in.peek();
  }

  public int min(){
    if (minStack.isEmpty()) {
      return -1;
    }
    return minStack.peek();
  }
}
