Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]


public class Solution {
  public String[] topKFrequent(String[] comb, int k){
    if (comb.length == 0) {
      return new Sting[0];
    }

    Map<String, Integer> freqMap = getFreqMap(comb);
  }

  private Map<String, Integer> getFreqMap(String[] comb){
    Map<String, Integer> freqMap = new HashMap<>();
    for (Sting s:comb) {
      Integer freq = freqMap.get(s);
      if (freq == null) {
        freqMap.put(s, 1);
      } else {
        freqMap.put(s, freq+1);
      }
    }
  }
}
