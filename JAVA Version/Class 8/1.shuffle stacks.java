Example:



stack1 = [8,4,6,1]  stack2 = []



After shuffle:

stack1 = [], stack2 = [1, 6, 4, 8]

class Solution {
	public void shuffle(Deque<Integer> stack1, Deque<Integer> stack2) {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
  }
}
