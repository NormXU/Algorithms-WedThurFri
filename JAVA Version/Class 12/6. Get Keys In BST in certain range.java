Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]

-subproblem
 if (root.val <= min) 则，root不再向左走  ---> if (root.val > min) 则，root向左走
 if (root.val >= max) 则，roo不再向右走   --->  if (root.val > min) 则，root向右走



 """
 Code
 
 """
 public class Solution {
   public List<Integer> getRange(TreeNode root, int min, int max) {
     // Write your solution here
     List<Integer> list = new ArrayList<Integer>();
     if(root == null){
       return list;
     }
     getRange(root, min, max, list);

     return list;
   }
   private void getRange(TreeNode root, int min, int max, List<Integer> list){
     if(root == null){
       return;
     }
     if(root.key > min){
       getRange(root.left, min, max, list);
     }
     if(min <= root.key && root.key <= max){
       list.add(root.key);
     }
     if(root.key < max){
       getRange(root.right, min, max, list);
     }

   }
 }
