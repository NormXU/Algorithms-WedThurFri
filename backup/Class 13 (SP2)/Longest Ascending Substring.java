for each num in nums
     if(list.size()==0)
          add num to list
     else if(num > last element in list)
          add num to list
     else
          replace the element in the list which is the smallest but bigger than num



nums = [9  1  3  7  5  6  20]
9
1
1  3
1  3  7
1  3  5
1  3  5  6
1  3  5  6  20


public int lengthOfLIS(int[] nums){
  if (nums == null || nums.length == 0) {
    return 0;
  }
  ArrayList<Integer> list = new ArrayList<>();

  for (int num:nums) {
    if (list.size()==0 || num>list.get(list.size()-1)) {
      list.add(num);
    }else{
      int i = 0;
      int j = list.size()-1;
      while(i<j){
        int mid = i + (j - i) / 2;
        if (list.get(mid) < num) {
          i = mid + 1;
        }else{
          j = mid;
        }
      }
      list.set(j, num);
    }
  }
}
