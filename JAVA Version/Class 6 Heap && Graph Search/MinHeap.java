public class MinHeap{
  private int[] array;
  private int size;

  public MinHeap(int[] array){
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("cannot be null or empty");
    }
    this.array = array;
    size = array.length;
    heapity();
  }




  private void percolateDown(int index){
    // last node:  size - 1
    // last node's father: (size - 1 - 1) / 2
    while(index <= size/2 - 1){
      int leftChildIndex  = index * 2 + 1;
      int rightChildIndex  = index * 2 + 2;

      int swapChildIndex = leftChildIndex;

      if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
        swapChildIndex = rightChildIndex;
      }

      if (array[index] > array[swapChildIndex]) {
        swap(array, index, swapChildIndex);
      } else{
        break;
      }
      index = swapChildIndex;
    }
  }


  private void percolateUp(int index){
    while(index > 0){
      int parentIndex = (index - 1) / 2;
      if (array[parentIndex] > array[index]) {
        swap(array, parentIndex, index);
      }else{
        break;
      }
      index = parentIndex;
    }
  }
}
