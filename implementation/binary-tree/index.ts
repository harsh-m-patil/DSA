export class Node<T> {
	value: T;
	left: Node<T> | null = null;
	right: Node<T> | null = null;

	constructor(value: T) {
		this.value = value;
	}
}
export class BinaryTree<T> {
	createFromInorderAndPreorder(inorder: number[], preorder: number[]) {}
}
