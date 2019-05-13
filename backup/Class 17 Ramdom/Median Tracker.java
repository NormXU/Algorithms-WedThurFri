Given an unlimited flow of numbers, keep track of the median of all elements seen so far.

You will have to implement the following two methods for the class

read(int value) - read one value from the flow
median() - return the median at any time, return null if there is no value read so far
Examples

read(1), median is 1
read(2), median is 1.5
read(3), median is 2
read(10), median is 2.5
......

public class MedianTracker(){
  private PriorityQueue<Integer> smallerHalf;
  private PriorityQueue<Integer> largerHalf;

  public MedianTracker(){
    // for the smaller half, we used a max-heap
    // for the larger half, we used a min-heap
    larger = new PriorityQueue<Integer>();
    smaller = new PriorityQueue<Integer>(11, Collections.reverseOrder());
  }

  public void read(int value){
    if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
      smallerHalf.offer(value);
    } else {
      largerHalf.offer(value);
    }
    
  }
}
