{2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5.
The indices of the left and right boundaries are 0 and 2, respectively.


array 2  -1  4  -2  1
m     2   1  5   3  4


 -2  -1  -3
 -2  -1  -3

 2  -1  4  -7  1  6
 2   1  5  -3  1  7
gM 2
               cL
                  cR
 gL
         gR


 public class Solution {
   public int largestSum(int[] array) {
     int[] mArray = new int[array.length];
     mArray[0] = array[0];
     int Left = 0;
     int GlobalLeft = 0;
     int GlobalRight = 0;
     int globalMax = array[0];
     for (int i = 1; i < array.length; i++) {
       if (mArray[i-1] + array[i] < array[i]) {
         mArray[i] = array[i];
         Left = i;
       } else {
         mArray[i] = mArray[i-1] + array[i];
       }
       if (globalMax < mArray[i]) {
         globalMax = mArray[i];
         GlobalLeft = Left;
         GlobalRight = i;
       }
     }
     return new int[]{globalMax, GlobalLeft, GlobalRight};
   }
 }
