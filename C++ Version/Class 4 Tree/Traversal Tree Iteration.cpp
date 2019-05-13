struct TreeNode{
  int value;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int n){
    left = NULL;
    right = NULL;
    value = n;
  }
}

"""
   1
  / \
 2   3
/ \
4   5

遍历顺序 [1,2,4,5,3]

"""
stack 1
stack 3 2          print 1
stack 3 5 4        print 1 2
stack 3 5          print 1 2 4
stack 3            print 1 2 4 5
stack null         print 1 2 4 5 3

void preOrder(TreeNode* root){
  if (root == NULL) {
    return;
  }
  stack<TreeNode*> s;
  s.push(root);
  while (!s.empty()) {
    TreeNode* tmp = s.pop();
    cout << tmp-> value << " ";
    if (tmp -> right) {
      s.push(tmp -> right);
    }
    if (tmp -> left) {
      s.push(tmp -> left);
    }
  }
  cout << endl;
}
