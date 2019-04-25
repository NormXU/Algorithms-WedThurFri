// Case 1
{ A B C 1 2 3}  -> { A 1 B 2 C 3}
// Case 2
{ A B C 1 2 3 4}  -> { A 1 B 2 C 3 4}

 A B C 1 2 3
   l M M r
 A C B 2 1 3

 A 1 2 B C 3

 A B C D E F G 1 2 3 4 5 6 7
       L     M       R

 A B C G F E D 4 3 2 1 5 6 7
       L     M       R

 A B C 1 2 3 4 D E F G 5 6 7
       L     M       R

class Solution{
public:
  void solve(vector<int>& array){
    reorder(array);
  }
  void reorder(std::vector<int>& array) {
    if (array.size() % 2 == 0) {
      reorderH(array, 0, array.size()-1);
    }else{
      reorderH(array, 0, array.size()-2);
    }
  }
  void reorderH(std::vector<int>& array, int left, int right) {
    int length = right - left + 1;
    if (length <= 2) {
      return;
    }
    int mid  = left + (right - left) / 2;
    //int Lmid = left + (mid - left) / 2;
    //int Rmid = mid+1 + (right - mid - 1) / 2;
    int Lmid = mid - (length + 2) / 4 + 1;
    int Rmid = mid + length / 4;
    reverse(array, Lmid, mid);
    reverse(array, mid+1,Rmid);
    reverse(array, Lmid, Rmid);
    if (length % 4 == 0) {
      reorderH(array, left, mid);
      reorderH(array, mid+1, right;)
    }else{
      reorderH(array, left, mid-1);
      reorderH(array, mid, right;)
    }

  }

  void reverse(std::vector<int> &array, int left, int right) {
    while (left < right) {
      int tmp = array[left];
      array[left] = array[right];
      array[right] = tmp;
      left++;
      right--;
    }
  }
}
