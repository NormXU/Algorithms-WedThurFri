/*
Given an array of integers, sort the elements in the array in ascending order. The quick sort algorithm should be used to solve this problem.

Examples

{1} is sorted to {1}
{1, 2, 3} is sorted to {1, 2, 3}
{3, 2, 1} is sorted to {1, 2, 3}
{4, 2, -3, 6, 1} is sorted to {-3, 1, 2, 4, 6}
*/

public class Solution {
  public int[] quickSort(int[] array) {
    // Write your solution here
    if(array == null){
      return array;
    }
    quicksort(array, 0, array.length-1);
    return array;
  }

  public void quicksort(int[] array, int left, int right){
    if(left >= right){
      return;
    }
    // Use that pivot to partition the array
    int pivotIdx = partition(array, left, right);
    quicksort(array, left, pivotIdx - 1);
    quicksort(array, pivotIdx + 1, right);

  }
  private int partition(int[] array, int left, int right){
    int pivotIdx = left + (int)(Math.random()*(right-left+1));
    int pivot = array[pivotIdx];
    // put the pivot at the rightmost of the array
    swap(array, pivotIdx, right);
    int leftBound = left;
    int rightBound = right - 1;
    while(leftBound <= rightBound){
      if(array[leftBound] < pivot){
        leftBound++;
      }else{
        swap(array, leftBound, rightBound);
        rightBound--;
      }
    }
    swap(array, leftBound, right);
    return leftBound;


  }
  private void swap(int[] array, int left, int right){
    int tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }
}
