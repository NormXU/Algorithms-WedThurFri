Given an original string input, and two strings S and T, replace all occurrences of S in input with T.

Assumptions

input, S and T are not null, S is not empty string
Examples

input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
input = "dodododo", S = "dod", T = "a", input becomes "aoao"
================================================================================
d o d o d o d o
f
public class Solution {
  public String replace(String input, String source, String target) {
    // Write your solution here
    StringBuilder sb = new StringBuilder();
    int fromIndex = 0;
    int matchIndex = input.indexOf(s, fromIndex);
    while (matchIndex != -1) {
      sb.append(input, fromIndex, matchIndex).append(target);
      // Next Time we need to start from new position after update
      fromIndex = matchIndex + s.length();
      matchIndex = input.indexOf(source, fromIndex);
    }
    sb.append(input, fromIndex, input.length());
    return sb.toString();
  }


}
