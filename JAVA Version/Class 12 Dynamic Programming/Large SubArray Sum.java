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
