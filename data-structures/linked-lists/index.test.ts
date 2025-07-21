import { describe, it, expect, beforeEach } from "vitest";
import { LinkedList } from ".";

describe("LinkedList", () => {
	let list: LinkedList<number>;

	beforeEach(() => {
		list = new LinkedList<number>();
	});

	it("should append elements to the list", () => {
		list.append(10);
		list.append(20);
		list.append(30);

		expect(list.toArray()).toEqual([10, 20, 30]);
	});
	it("should return correct size of  the list", () => {
		list.append(10);
		list.append(20);
		list.append(30);

		expect(list.size()).toBe(3);
	});

	it("should prepend elements to the list", () => {
		list.prepend(10);
		list.prepend(20);
		list.prepend(30);

		expect(list.toArray()).toEqual([30, 20, 10]);
	});

	it("should insert elements at the right index in the list", () => {
		list.append(10);
		list.append(30);
		list.insert(1, 20);

		expect(list.toArray()).toEqual([10, 20, 30]);
	});

	it("should delete the element at the given index", () => {
		list.append(10);
		list.append(20);
		list.append(30);
		expect(list.delete(2)).toBe(true);

		expect(list.toArray()).toEqual([10, 20]);
	});
});
