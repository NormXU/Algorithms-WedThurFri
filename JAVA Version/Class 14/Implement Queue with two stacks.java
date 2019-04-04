public class Solution {
  Deque<Integer> in;
  Deque<Integer> out;

  public Solution() {
    // Write your solution here.
    in = new LinkedList<Integer>();
    out = new LinkedList<Integer>();
  }
  private void shuffle(){
    if(out.isEmpty()){
      while(!in.isEmpty()){
        out.push(in.pop());
      }
    }
  }
  public Integer poll() {
    shuffle();
    if(out.isEmpty()){
      return null;
    }
    return out.pop();
  }

  public void offer(int element) {
    in.push(element);
  }

  public Integer peek() {
    shuffle();
    if(out.isEmpty()){
      return null;
    }
    return out.peek();
  }

  public int size() {
    return in.size() + out.size();
  }

  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }
}
