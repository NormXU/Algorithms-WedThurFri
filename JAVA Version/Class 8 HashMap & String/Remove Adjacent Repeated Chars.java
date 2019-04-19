public class Solution {
  public String deDup(String input) {
    // Write your solution here
    if(input == null){
      return null;
    }
    char[] arrayChar = input.toCharArray();
    if(arrayChar.length == 0){
      return "";
    }
    int slow = 1;
    int fast = 1;
    while(fast < arrayChar.length){
      if(arrayChar[slow-1] == arrayChar[fast]){
        fast += 1;
      }else{
        arrayChar[slow] = arrayChar[fast];
        slow += 1;
        fast += 1;
      }
    }
    return new String(arrayChar, 0, slow);
  }
}
