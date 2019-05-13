public class Solution {
  public int longest(int[] array) {
    // Write your solution here
    if(array.length == 0){
      return 0;
    }
    int[] M = new int[array.length];
    M[0] = 1;
    for(int i = 0; i < array.length-1; i++){
      if(array[i] < array[i+1]){
        M[i+1] = M[i] + 1;
      }else{
        M[i+1] = 1;
      }
    }
    int globalMax = 0;
    for(int i = 0; i < array.length; i++){
      if(M[i] > globalMax){
        globalMax = M[i];
      }
    }
    return globalMax;
  }
}
