void swap(std::vector<int>& input, int a, int b) {
  int temp = input[a];
  input[a] = input[b];
  input[b] = temp;
}

void moveZerosToRightSide(std::vector<int>& input) {
  if (input.size() <= 1) {
    return;
  }
  int left = 0;
  int right = input.size() - 1;
  while (left <= right) {
    if (input[left] == 0) {
      swap(input, left, right);
      right--;
    } else {
      left++;
    }

  }
}
