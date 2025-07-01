function minimumOperations(nums: number[]): number {
	let count = 0;
	if (isDistinct(nums)) return count;
	while (!isDistinct(nums) || nums.length > 3) {
		count++;
		nums.shift();
		nums.shift();
		nums.shift();
	}

	return count;
}

function isDistinct(nums: number[]): boolean {
	const set = new Set<number>();

	for (const num of nums) {
		if (set.has(num)) {
			return false;
		}
		set.add(num);
	}
	return true;
}

console.log(minimumOperations([1, 2, 3, 4, 2, 3, 3, 5, 7]));
console.log(minimumOperations([4, 5, 6, 4, 4]));
console.log(minimumOperations([6, 7, 8, 9]));
