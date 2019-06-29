Find all pairs of elements in a given array that
sum to the pair the given target number. Return all the distinct pairs of values.
     0  1  2  3  4  5  6  7
A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Integer> map  = new HashMap<>();
    for(int num : array){
      // Two cases:
      // 1. 2 * x == target, we need to check there is no duplicates
      // 2. x + y == target. we need to check there is no duplicates
      Integer count = map.get(num);
      if(num * 2 == target && count != null && count == 1){
        result.add(Arrays.asList(num, num));
      } else if (map.containsKey(target - num) && count == null) {
        result.add(Arrays.asList(target - num, num));
      }

      if (count == null) {
        map.put(num ,1);
      } else {
        map.put(num, count + 1);
      }

    }
    return result;
  }
}

1: 1
2: 3
3: 2
4: 2
