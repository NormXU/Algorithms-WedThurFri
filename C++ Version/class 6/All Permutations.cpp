"abc"  => "abc", "acb", "bac", "bca", "cab", "cba"

using namespace std;
class Solution {
public:
  std::vector<string> permutation(std::string input) {
    std::vector<string> result;
    permutation(input, 0, result);
    return result;
  }
  void swap(string& array, int left, int right){
    char tmp     = array[left];
    array[left]  = array[right];
    array[right] = tmp;
  }
  void permutation(string& array, int index, std::vector<string>& result){
    if (index == array.size()) {
      result.push_back(array);
      return
    }
    for (int i = index; i < array.size(); i++) {
      swap(array, index, i);
      permutation(array, index+1, result);
      swap(array, index, i);
    }
  }
};
