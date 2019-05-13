void preOrderTraversal(TreeNode* root) {
  if (!root) {
    return;
  }
  cout << root->value << endl;
  preOrderTraversal(root->left);
  preOrderTraversal(root->right);
}

void inOrderTraversal(TreeNode* root) {
  if (!root) {
    return;
  }

  preOrderTraversal(root->left);
  cout << root->value << endl;
  preOrderTraversal(root->right);
}

void postOrderTraversal(TreeNode* root) {
  if (!root) {
    return;
  }

  preOrderTraversal(root->left);
  preOrderTraversal(root->right);
  cout << root->value << endl;
}
