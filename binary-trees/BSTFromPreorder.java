/**
 * Definition for a binary tree node.
 */

import java.util.*;

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
  public TreeNode bstFromPreorder(int[] preorder) {
    int[] inorder = Arrays.copyOfRange(preorder, 0, preorder.length);
    // we can get the inorder traversal of a BST from sorted preorder
    Arrays.sort(inorder);

    Deque<Integer> dq = new ArrayDeque<>();

    for (int val : preorder) {
      dq.offer(val);
    }

    return createTree(inorder, dq);
  }

  private static TreeNode createTree(int[] inorder, Deque<Integer> preorder) {
    if (inorder.length > 0) {
      int idx = indexOf(inorder, preorder.poll());
      TreeNode root = new TreeNode(inorder[idx]);

      root.left = createTree(Arrays.copyOfRange(inorder, 0, idx), preorder);
      root.right = createTree(
          Arrays.copyOfRange(inorder, idx + 1, inorder.length), preorder);
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
