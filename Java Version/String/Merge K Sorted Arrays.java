K  k1 k2 k3 k4 ...
M  m1 m2 m3 m4 ...
N  n1 n2 n3 n4 ...
   .......
相当于把每一个list的第一个元素压入heap当中， heapify， 然后把pop出去的元素再补上这个list的下一个元素

public class MergeKSortedArrays {
  public int[] merge(int[][] arrayOfArrays){

    PriorityQueue<Entry> minHeap = new PriorityQueue<>(11, new MyComparator());
    int length = 0;
    for (int i = 0; i < arrayOfArrays.length; i++) {
      int[] array = arrayOfArrays[i];
      length = length + array.length;
      if (array.length != 0) {
        minHeap.offer(new Entry(i, 0, array[0]));
      }
    }
    int[] result = new int[length];
    int cur = 0;
    while (!minHeap.isEmpty()) {
      Entry tmp = minHeap.poll();
      result[cur++] = tmp.value;
      if (tmp.y + 1 < arrayOfArrays[tmp.x].length) {
        tmp.y++;
        tmp.value = arrayOfArrays[tmp.x][tmp.y];
        minHeap.offer(tmp);
      }
    }
    return result;

  }


  static class MyComparator implements Comparator<Entry> {
    @Override
    public int compare(Entry e1, Entry e2){
      if (e1.value == e2.value) {
        return 0;
      }
      return e1.value < e2.value ? -1 : 1;
    }
  }

  static class Entry{
    // Row Number
    int x;
    // Column Number
    int y;
    // The Corresponding Value
    int value;

    Entry(int x, int y, int value){
      this.x = x;
      this.y = y;
      this.value = value;
    }
  }

}
