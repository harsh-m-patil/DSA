import java.util.*;
/**
 * Definition for a binary tree node.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    Stack<Integer> postStack = new Stack<>();

    for (int val : postorder) {
      postStack.push(val);
    }

    return build(inorder, postStack);
  }

  private TreeNode build(int[] inorder, Stack<Integer> postorder) {
    if (inorder.length > 0) {
      int idx = indexOf(inorder, postorder.pop());
      TreeNode root = new TreeNode(inorder[idx]);
      root.right = build(Arrays.copyOfRange(inorder, idx + 1, inorder.length),
                         postorder);
      root.left = build(Arrays.copyOfRange(inorder, 0, idx), postorder);
      return root;
    }
    return null;
  }

  private static int indexOf(int[] inorder, int val) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == val) {
        return i;
      }
    }
    return -1;
  }
}
