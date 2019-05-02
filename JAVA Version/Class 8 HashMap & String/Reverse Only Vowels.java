public class Solution {
  public boolean isVowel(char c){
    return (c == 'a' || c == 'e'|| c == 'i'|| c == 'o'||
            c == 'u'|| c == 'A' || c == 'E'|| c == 'I'||
            c == 'O'|| c == 'U');
  }
  public void swap(char[] array, int left, int right){
    char tmp = array[left];
    array[left] = array[right];
    array[right] = tmp;
  }
  public String reverse(String input) {
    // Write your solution here
    char[] arrayChar = input.toCharArray();
    int start = 0;
    int end   = arrayChar.length-1;
    while (start <= end){
      while(!isVowel(arrayChar[start]) && start != end){
        start++;
      }
      while(!isVowel(arrayChar[end]) && start != end){
        end--;
      }
      swap(arrayChar, start, end);
      start++;
      end--;
    }
    return new String(arrayChar);
  }
}
