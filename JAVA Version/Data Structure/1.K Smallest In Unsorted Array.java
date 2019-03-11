class Node{
  int value;
  public Node(int v){
    value = v;
  }
}

class NodeComparator implements Comparator {
  @Override
  public int compare(int o1, int o2){
    if (o1.value > o2.value) {
      return -1;
    }
    if (o1.value < o2.value) {
      return 1;
    }
    return 0;
  }
}


Examples

A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
首先取K个元素，进行heapify, max-heap； 然后接着遍历，如果遇到了比max-heap的值还要小的元素，则进行swap

public class Solution{
  public int[] kSmallest(int[] array, int k){
    if (array.length == 0 || k == 0) {
      return new int[0];
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,
                                                                new Comparator<Integer>(){
                                                                  @Override
                                                                  public int compare(Integer o1, Integer o2){
                                                                    if (o1.equals(o2)) {
                                                                      return 0;
                                                                    }
                                                                    return o1 > o2 ? -1:1;
                                                                  }
                                                                }

                                                                )
    for (int i = 0; i < array.length; i++) {
      if (i < k) {
        maxHeap.offer(array[i]);
      } else if (array[i] < maxHeap.peek()) {
        maxHeap.poll();
        maxHeap.offer(array[i]);
      }
    }

    int [] result = new int[k];
    for (int i = k-1; i >= 0 ;i-- ) {
      result[i] = maxHeap.poll();
    }
    
    return result;
  }

}
