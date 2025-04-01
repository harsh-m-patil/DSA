export class Node<T> {
	value: T;
	next: Node<T> | null = null;

	constructor(value: T) {
		this.value = value;
	}
}

export class LinkedList<T> {
	private head: Node<T> | null = null;
	private _size: number = 0;

	insert(index: number, value: T): void {
		if (index < 0 || index > this._size) {
			throw new Error("IndexOutOfBound Exception");
		}

		const newNode = new Node(value);

		if (index === 0) {
			newNode.next = this.head;
			this.head = newNode;
		} else {
			let i = 0;
			let current = this.head;

			while (current && i < index - 1) {
				current = current.next!;
				i++;
			}

			newNode.next = current!.next;
			current!.next = newNode;
		}

		this._size++;
	}

	append(value: T): void {
		this._size++;
		const newNode = new Node(value);
		if (!this.head) {
			this.head = newNode;
			return;
		}

		let current = this.head;
		while (current.next) {
			current = current.next;
		}

		current.next = newNode;
	}

	prepend(value: T): void {
		this._size++;
		const newNode = new Node(value);
		newNode.next = this.head;
		this.head = newNode;
	}

	delete(index: number): boolean {
		if (index < 0 || index >= this._size) {
			return false;
		}

		if (!this.head) {
			return false;
		}

		if (index === 0) {
			this.head = this.head.next;
			this._size--;
			return true;
		}

		let i = 0;
		let current = this.head;

		while (current.next && i < index - 1) {
			current = current.next;
			i++;
		}

		if (current.next) {
			current.next = current.next.next;
			this._size--;
			return true;
		}

		return false;
	}

	get(index: number): T | null {
		if (index < 0 || index >= this._size) {
			throw new Error("IndexOutOfBound Exception");
		}

		let i = 0;
		let current = this.head;

		while (current && i < index) {
			current = current.next!;
			i++;
		}

		return current ? current.value : null;
	}

	size(): number {
		return this._size;
	}

	toArray(): T[] {
		let result: T[] = [];
		let current = this.head;

		while (current) {
			result.push(current.value);
			current = current.next;
		}
		return result;
	}
}
