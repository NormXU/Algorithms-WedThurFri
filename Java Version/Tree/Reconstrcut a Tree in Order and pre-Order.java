           10

         /    \

        5      15

     /    \    /   \

    2     7   12    20

index:             0  1  2  3  4    5   6
preorder:  中左右  10  5  2  7  15  12  20
                   pL
inOrder:   左中右   2  5  7 10  12  15  20
                   iL       i

比如说先在pre-order中找到了10，然后在 inOrder中寻找10的index为3，所以其左侧都是10的左子树，其右侧都是
10的右子树

public TreeNode construct(int[] in, int inLeft, int inRight,
                          int[] pre, int preLeft, int preRight,
                          Map<Integer, Integer> idxMap){
  if (inLeft > inRight) {
    return null;
  }

  TreeNode root = new TreeNode(pre[preLeft]);
  int leftSize  = idxMap.get(root.key) - inLeft; // the size of left-subtree
  root.left = construct(in,  inLeft,    inLeft + leftSize - 1,
                        pre, preLeft+1, preLeft + leftSize,
                        idxMap);
  root.right = construct(in,  inLeft + leftSize + 1,  inRight,
                         pre, preLeft + leftSize + 1, preRight,
                         idxMap);
  return root;

}



================================================================================
public class Solution {
  public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
    // Write your solution here
    Map<Integer, Integer> inIndex = indexMap(inOrder);
    return helper(preOrder, inIndex, 0, inOrder.length - 1, 0, preOrder.length - 1);
  }

  private Map<Integer, Integer> indexMap(int[] in){
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < in.length; i++){
          map.put(in[i], i);
      }
      return map;
  }

  private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight){
      if(inLeft > inRight){
          return null;
      }
      TreeNode root = new TreeNode(pre[preLeft]);
      int inMid  = inIndex.get(root.key);
      root.left  = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
      root.right = helper(pre, inIndex, inMid + 1, inRight, preRight + inMid - inRight + 1, preRight);
      return root;
  }
}
