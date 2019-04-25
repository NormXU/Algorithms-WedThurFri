s1 [ 4
s2 [ 7
s3 [ 4 7

假设啊，我们有一个function helper 可以把 s1中的元素和s2中的元素都按照从小到大的顺序压入s3中

void Helper(stack<int>& s1, stack<int>& s2, int size){
  if (size <= 1) {
    return;
  }
  int mid = size / 2;
  int rest = size - mid;
  for(int i = 0; i < mid; i++){
    s2.push(s1.pop());
  }
  Helper(s2, s3, s1, mid); //把s2和s3的元素多有元素按照从小到大压入s1
  Helper(s1, s3, s2, rest); //把s1和s3的元素多有元素按照从小到大压入s2

  int i = 0;
  int j = 0;
  while (i<mid && j < rest) {
    if (s2.top() < s1.top()) {
      s3.push(s2.pop());
      i++;
    } else{
      s3.push(s1.pop());
      j++;
    }
  }

  while (i < mid) {
    s3.push(s2.pop());
    i++;
  }

  while (j < mid) {
    s3.push(s1.pop());
    j++;
  }
  //排好后。重新压回s1中
  for(int index = 0; index < size; index++){
    s1.push(s3.pop());
  }


}
