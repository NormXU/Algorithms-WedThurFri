Given N pairs of parentheses “()”, return a list with all the valid permutations.

**Assumptions**

- N > 0

**Examples**

- N = 1, all valid permutations are ["()"]
- N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]


public class Solution {
  public List<String> validParentheses(int n) {
    // Write your solution here
    List<String> result = new ArrayList<>();
    char[] cur = new char[n*2];

    helper(cur, n, n, 0, result);
    return result;
  }

  private void helper(char[] cur, int left, int right, int index, List<String> result){
    // left: how many '( ' we still have to fill
    // right: how many ') ' we still have to fill
    // Index: The Current Position we want to fill
    if(left == 0 && right == 0){
      result.add(new String(cur));
      return;
    }
    if(left > 0){
      cur[index] = '(';
      helper(cur, left-1, right, index+1, result);
    }
    if(right > left){
      cur[index] = ')';
      helper(cur, left, right-1, index+1, result);
    }
  }
}


With back-Propagation
private void DFS(int n, int l, int r, StringBuilder solu){
  if(l == n && r == n){
    return;
  }
  if(l < n){
    solu.append('(');
    DFS(n, l+1, r, solu);
    solu.deleteCharAt(solu.length() - 1);
  }
  if(l > r){
    solu.append(')');
    DFS(n, l, r+1, solu);
    solu.deleteCharAt(solu.length() - 1);
  }
}
