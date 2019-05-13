Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.

Assumptions

s is not null or empty.
l is not null.
Examples

l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
M 2
a : 0,  b: 0
result 0

s = a b

l = a b c b a c
            i
          j


public class Solution {
  public List<Integer> allAnagrams(String s, String l) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    if(l.length() == 0){
      return result;
    }
    if(s.length() > l.length()){
      return result;
    }
    Map<Character, Integer> map = countMap(s);
    int match = 0;

    for(int i = 0; i < l.length(); i++){
      char tmp = l.charAt(i);
      Integer count = map.get(tmp);
      if (count != null){
        map.put(tmp, count - 1);
        if (count == 1){
          match++;
        }
      }
     if(i >= s.length()){
       tmp = l.charAt(i - s.length());
       count = map.get(tmp);
       if(count != null){
         map.put(tmp, count + 1);
        if (count == 0){
          match--;
        }
       }
     }
      if (match == map.size()){
        result.add(i - s.length() + 1);
      }
    }
    return result;
  }
  private Map<Character, Integer> countMap(String s){
    Map<Character, Integer> map = new HashMap<>();
    for(char ch : s.toCharArray()){
      Integer count = map.get(ch);
      if (count == null){
        map.put(ch, 1);
      } else {
        map.put(ch, count + 1);
      }
    }
    return map;
  }
}
