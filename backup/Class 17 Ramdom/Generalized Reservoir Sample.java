Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far.

Assumptions

k >= 1
You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
You may need to add more fields for the class.
================================================================================

public class Solution {
  private final int k;
  private int count;
  private List<Integer> sample;

  public Solution(int k) {
    if (k <= 0) {
      throw new IllegalArgumentException("k must be > 0");
    }
    this.k = k;
    this.count = 0;
    sample = new ArrayList<>();
  }

  public void read(int value){
    count++;
    if (count <= k) {
      sample.add(value);
    } else {
      int random = (int) (Math.random() * count);
      if (random < k) {
        sample.set(random, value);
      }
    }
  }

  public List<Integer> sample(){
    return sample;
  }
}


=====【招短租】======
【坐标】 The Carlyle Apartments, 离Hopkins Homewood campus北门步行五分钟路程。附近有便利店和Giant。生活十分便利。
楼顶夏天有游泳池对住户开放，楼下有免费的健身房。
------------------------------
招租的户型是【3b3b】，每一个卧室都有自己独立的卫生间。短租时间是【6月-8月份】，可续租。5月底，我们三人都会离开Baltimore，所以从6月初开始，整个
房间都会空置。但您可以选择只租一间卧室，每个月租金【950刀】左右（根据当月水电费用浮动。
