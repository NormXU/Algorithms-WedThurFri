Sort an array range from 0.0 to 1.0

class Solution {
  public void bucketSort(double[] array){
    int n = array.length;
    List<List<Double>> helper = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      helper.add(new ArrayList<Double>());
    }

    for (double d: array ) {
      int indx = (int)(n*d);
      helper.get(indx).add(d);
    }

    for (List<Double> list: helper ) {
      Collections.sort(list);
    }
    
    int index = 0;
    for (List<Double> list : helper ) {
      for (double d : list ) {
        array[index] = d;
        index++;
      }
    }
  }
}
