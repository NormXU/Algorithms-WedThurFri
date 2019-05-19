Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
For example, “aba |b | bbabb |a| b| aba” is a palindrome partitioning of “ababbbabbababa”. Determine the fewest cuts needed for palindrome partitioning of a given string.
For example, minimum 3 cuts are needed for “ababbbabbababa”. The three cuts are “a | babbbab | b | ababa”.
If a string is palindrome, then minimum 0 cuts are needed. aba | b | bbabb | a | b | aba - 5 cuts

a | babbbab | b | ababa - 3 cuts



The three cuts are “a | babbbab | b | ababa”.
If a string is palindrome, then minimum 0 cuts are needed. aba | b | bbabb | a | b | aba - 5 cuts

a | babbbab | b | ababa -- 3 cuts

===============================================================================

Time : O(n^3)
Space: O(n)

dp[i] = substring[0, i]: what is the min number of cuts to make each partition palindrome.

===============================================================================
public int minCut(String input){
  if (input == null || input.length() == 0) {
    return 0;
  }
  int len  = input.length();
  int[] dp = new int[len];
  dp[0]    = 0;
  for (int i = 1; i < len; i++) { // grow one letter by one letter
    if (isPalin(input, 0, i)) {
      dp[i] = 0;
      continue;
    }
    dp[i] = i;
    for (int j = 1; j <= i; i++) { // enumerate all possible right small sections
      if (isPalin(input, j, i)) {
        dp[i] = Math.min(dp[i], dp[i-1] + 1);
      }
    }
  }
  return dp[len-1];
}

private boolean isPalin(String input, int start, int end){
  while (start < end) {
    if (input.charAt(start++) != input.charAt(end--)) {
      return false;
    }
  }
  return true;
}
