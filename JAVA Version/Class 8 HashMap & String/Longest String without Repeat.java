public class Solution {
  public int longest(String input) {
    // Write your solution here
    char[] array = input.toCharArray();
    Set<Character> distinct = new HashSet<>();
    int end = 0;
    int longest = 0;
    int fast = 0;
    while(fast < array.length){
      if (distinct.contains(array[fast])) {
        distinct.remove(array[end]);
        end++;

      } else{
        distinct.add(array[fast]);
        fast++;
        longest = Math.max(longest, fast - end );
      }
    }
    return longest;
  }
}
