public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    // Write your solution here
    if(combo.length == 0){
      return new String[0];
    }

    Map<String, Integer> freqMap = getFreqMap(combo);

    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
    @Override
      public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        return e1.getValue().compareTo(e2.getValue());
      }
    });

    for(Map.Entry<String, Integer> entry: freqMap.entrySet()){
      if(minHeap.size() < k){
        minHeap.offer(entry);
      }else if(entry.getValue() > minHeap.peek().getValue()){
        minHeap.poll();
        minHeap.offer(entry);
      }
    }

    String[] result = new String[minHeap.size()];
    for(int i = minHeap.size()-1; i >= 0; i--){
      result[i] = minHeap.poll().getKey();
    }
    return result;

  }

  private Map<String, Integer> getFreqMap(String[] comb){
    Map<String, Integer> freqMap = new HashMap<>();
    for(String s: comb){
      Integer freq = freqMap.get(s);
      if(freq == null){
        freqMap.put(s, 1);
      }else{
        freqMap.put(s, freq+1);
      }
    }
    return freqMap;
  }
}
