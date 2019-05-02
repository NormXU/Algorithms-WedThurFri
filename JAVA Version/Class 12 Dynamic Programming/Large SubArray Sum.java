Idx   0  1  2  3  4  5  6
Num   1  3  7 -10 -20 10 9
Cur   1  4  11 -3 -20 10 19




public class LargeSubArray{
  public int LargeSubArray(int[] array){
    int result = array[0];
    int cur    = array[0];
    for (int i = 1; i<array.length ; i++ ) {
      cur = Math.max(cur + array[i], array[i]);
      result = Math.max(result, cur);
    }
  }
}


1. Base Case
当长度为1的时候，最大值是array[0]
2. Induction Rule
M[i] = M[i-1] + array[i]


public class LargeSubArray{
  public int LargeSubArray(int[] array){
    int left, right = 0, 0;
    int result = array[0];
    int cur    = array[0];
    for (int i = 1; i < array.length ; i++ ) {
      int temp = 0;
      if (cur < 0) {
        temp = i;
        cur = array[i]
      } else {
        cur = cur + array[i];
      }
      if (result < cur) {
        result = cur;
        left = temp;
        right = i;
      }
    }
    int[] res = new int[]{result, left, right};
    result res;
  }
}
