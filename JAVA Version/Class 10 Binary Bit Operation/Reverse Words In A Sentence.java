"I Love Google" <==> "Google Love I"
public class Solution {
  public String reverseWord(String input){
    char[] array = input.toCharArray();
    int start = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] != ' ' && (i == 0 || array[i-1] == ' ')) {
        start = i;
      }
      if (array[i] != ' ' && (i == array.length - 1 || array[i+1] == ' ')) {
        reverse(start, i, array);
      }
    }

    return new String(array);
  }


  private void reverse(int left, int right, char[] array){
    while (left < right) {
      char tmp     = array[right];
      array[right] = array[left];
      array[left]  = tmp;
      left++;
      right--;
    }
  }
}
