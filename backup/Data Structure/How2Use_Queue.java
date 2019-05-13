/*
Maximum Number in a Queue
*/
class Solution{
  public int maxInQueue(Queue<Integer> queue){
    int max = queue.poll();
    while (!queue.isEmpty()) {
      max = Math.max(max, queue.poll());
    }
    return max;
  }
}
