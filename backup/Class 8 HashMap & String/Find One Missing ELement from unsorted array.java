public class MissingNumber {
  public int missingI(int[] array){
    int n = array.length - 1;
    HashSet<Integer> set = new HashSet<>();
    for (int number : array) {
      set.add(number);
    }
    for (int i = 1;i < n ;i++ ) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return n;
  }
}
