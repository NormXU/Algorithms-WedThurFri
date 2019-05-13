Implementation Of Capacity Limited Min Heap Empty version:

public class MinHeap{
  private int[] Heap;
  private int size;
  private int maxsize;

  public MinHeap(int maxsize){
    this.maxsize = maxsize;
    this.size    = size;
    Heap = new int[this.maxsize + 1];
    Heap[0] = Integer.MIN_VALUE
  }
}
