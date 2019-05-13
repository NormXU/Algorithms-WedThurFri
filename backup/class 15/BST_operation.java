
// Rescursive
public TreeNode search(TreeNode root, int target){
  if (root == nul || root.key == target) {
    return root;
  }
  if (target < root.key) {
    return search(root.left, target);
  }else{
    return search(root.right, target);
  }
}


// Iterative
public TreeNode search(TreeNode root, int target){
  TreeNode currentNode = root;
  while (currentNode != null && currentNode.key != target) {
    if (target < currentNode.key) {
      currentNode = currentNode.left;
    }else{
      currentNode = currentNode.right;
    }
  }
  return currentNode;
}


###############################################################################

public TreeNode insert(TreeNode root, int target){
  TreeNode newNode = new TreeNode(target);
  if (root == null) {
    return newNode;
  }
  TreeNode current = root;
  while(current.key != target){
    if (current.key > target) {
      if (current.left != null) {
        current = current.left;
      }else{
        current.left = newNode;
        break;
      }
    }else{
      if (current.right != null) {
        current = current.right;
      }else {
        current.right = newNode;
        break;
      }
    }
  }
return root;
}

public TreeNode insert(TreeNode root, int key){
  if (root == null) {
    TreeNode newRoot = new TreeNode(key);
    return newRoot;
  }
  if (root.key < key) {
    root.right = insert(root.right, key);
  }else if(root.key > key){
    root.left = insert(root.left, key);
  }
  return root;
}
