How to find the k th smallest element from two sorted array?
a_left is the left border of A[]
b_left is the left border of B[]

A[k/2-1] 与 B[k/2-1] 作比较，谁小就删谁的前k/2

private int kth(int[] a, int a_left, int b[], int b_left, int k){

  if (a_left >= a.length) {
    return b[b_left + k - 1];
  }
  if (b_left >= b.length) {
    return a[a_left + k - 1];
  }
  if (k == 1) {
    return Math.min(a[a_left], b[b_left]);
  }
  // Find the mid element of the array
  int amid = a_left + k/2 - 1;
  int bmid = b_left + k/2 - 1;

  // if a.size is too small, then, remove element from b first
  int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
  int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];

  if (aval <= bval) {
    return kth(a, amid + 1, b, b_left, k - k/2);
  } else{
    return kth(a, a_left, b, bmid + 1, k - k/2);
  }

}


同样的问题还有 K-th Cloest Element
How to Find closest k element in the array that is closest to a target number?

{1, 2, 3, 8, 9}
       L  R

Target = 4
K = 3

方法一：中心开花
{1, 2, 3, 8, 9}
 L
          R
{1,2,3}

方法二
{1, 2, 3 || 8, 9}
{3,2,1}
            {4,5}
然后这个问题就转化为了，两个sorted array, 求 Kth smallest Element
