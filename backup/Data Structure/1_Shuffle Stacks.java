/*
Example:



stack1 = [8,4,6,1]  stack2 = []



After shuffle:

stack1 = [], stack2 = [1, 6, 4, 8]
*/

class Solution{
  public void shuffle(Deuqe<Integer> stack1, Deuqe<Integer> stack2){
    while(!stack1.isEmpty()){
      stack2.push(stack1.pop());
    }
  }
}
