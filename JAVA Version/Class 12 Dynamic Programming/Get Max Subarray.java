// Time: O(n)
// Space: O(n)

public int getMax(int[] input){
  int[] M = new int[input.length];
  M[0] = input[0];
  int globalMax = input[0];
  for (int i = 1; i < input.length; i++) {
    M[i] = Math.max(M[i-1] + input[i], input[i]);
    globalMax = Math.max(globalMax, M[i]);
  }
  return globalMax;
}

// Time: O(n)
// Space: O(1)
public int getMax(int[] input){
  int[] M = new int[input.length];
  M[0] = input[0];
  int globalMax = input[0];
  int lastElement = input[0];
  for (int i = 1; i < input.length; i++) {
    lastElement = Math.max(lastElement + input[i], input[i]);
    globalMax = Math.max(globalMax,lastElement);
  }
  return globalMax;
}
