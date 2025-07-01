import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public void flatten(TreeNode root) {
    List<TreeNode> pre = new ArrayList<>();
    dfs(root, pre);

    for (int i = 0; i < pre.size() - 1; i++) {
      pre.get(i).right = pre.get(i + 1);
      pre.get(i).left = null;
    }
  }

  public static void dfs(TreeNode root, List<TreeNode> pre) {
    if (root == null) {
      return;
    }

    pre.add(root);
    dfs(root.left, pre);
    dfs(root.right, pre);
  }
}
