/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function buildTree(preorder: number[], inorder: number[]): TreeNode | null {
  return build(preorder, inorder);
}

function build(preorder: number[] | null, inorder: number[]): TreeNode | null {
  if (inorder.length > 0) {
    const idx = inorder.indexOf(preorder.shift());
    const root = new TreeNode(inorder[idx]);

    root.left = build(preorder, inorder.slice(0, idx));
    root.right = build(preorder, inorder.slice(idx + 1, inorder.length));

    return root;
  }
  return null;
}
