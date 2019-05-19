Determine if there exists three elements in a given array that sum to the given target number.
Return all the triple of values that sums to target.

Examples

A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]

public class ThreeSum {
  public List<List<Integer>> allTriple(int[] array, int target){
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(array);
    for (int i = 0; i < array.length - 2; i++) {
      // find i < j < k, such that
      // array[i] + array[j] + array[k] == target
      if (i > 0 && array[i] == array[i-1]) {
        continue;
      }
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        int tmp = array[left] + array[right];
        if (tmp + array[i] == target) {
          result.add(Arrays.asList(array[i], array[left], array[right]));
          left++;
          while (left < right && array[left] == array[left-1]) {
            left++;
          }
        } else if (tmp + array[i] < target) {
          left++;
        } else {
          right--;
        }
      }

    }
    return result;
  }

}
