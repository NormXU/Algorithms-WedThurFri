Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).

After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.

Assumptions:

The given stack is not null.
There can be duplicated numbers in the give stack.


public class Solution {
  public void sort(LinkedList<Integer> s1) {
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    // Write your solution here.
    sort(s1, s2);

  }
  private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2){
    if(s1.size() <= 1){
      return;
    }
    while(s1.size() != 0){
      int tmp = s1.pop();


      while(s2.size() != 0 && s2.peek() > tmp){
        s1.push(s2.pop());
      }
      s2.push(tmp);
    }
    while(!s2.isEmpty()) {
			  s1.push(s2.poll());
		  }

  }
}
