import java.util.ArrayList;
import java.util.List;

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
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> li = new ArrayList<>();
    dfs(root, li);
    return li.get(k - 1);
  }

  public static void dfs(TreeNode root, List<Integer> li) {
    if (root == null) {
      return;
    }

    dfs(root.left, li);
    li.add(root.val);
    dfs(root.right, li);
  }
}
