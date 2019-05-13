{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

{-2, -1, -3}, the largest subarray sum is -1

a  2  -1  4  -7  1
m  2  1   5  -3  1
g  2


public class Solution {
  public int largestSum(int[] array) {
    // Write your solution here
    int[] m = new int[array.length];
    m[0] = array[0];
    int globalMax = m[0];
    for (int i = 1; i < array.length; i++) {
      m[i] = Math.max(m[i-1] + array[i], array[i]);
      globalMax = Math.max(m[i], globalMax);
    }
    return globalMax;
  }

}
