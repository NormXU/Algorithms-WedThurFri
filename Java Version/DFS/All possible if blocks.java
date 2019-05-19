// Time Complexity: O(2^n) We Go throght all the possible situations
// Space Complexty: O(1)

public class Solution{
  public void question4(int n) {
    if(n == 0){
      System.out.print('n cannot be 0');
      return;
    }
    helper(n, n, 0);
  }

  private void helper(char[] array, int left, int right, int index){
    if(left == 0 && right == 0){
      printSolution(array);
      return;
    }
    if(left > 0){
      array[index] = '{';
      helper(array, left-1, right, index+1);
    }
    if(right > left){
      array[index] = '}';
      helper(array, left, right-1, index+1);
    }
  }

  private void printSolution(char[] array){
    int heading = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == '{') {
        printSpace(heading);
        System.out.println("if {");
        heading += 2;
      } else {
        heading -= 2;
        printSpace(heading);
        System.out.println("}");

      }
    }
  }
}
