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
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    List<List<Integer>> outer = new ArrayList<>();

    if (root == null) {
      return outer;
    }

    q.add(root);

    while (!q.isEmpty()) {
      int levelSize = q.size();
      List<Integer> inner = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        TreeNode current = q.poll();
        inner.add(current.val);

        if (current.left != null) {
          q.add(current.left);
        }

        if (current.right != null) {
          q.add(current.right);
        }
      }

      outer.add(inner);
    }

    return outer;
  }
}
