function containsNearbyDuplicate(nums: number[], k: number): boolean {
	const idxMap = new Map<number, number>();

	for (let i = 0; i < nums.length; i++) {
		if (idxMap.has(nums[i]) && i - idxMap.get(nums[i]) <= k) return true;
		idxMap.set(nums[i], i);
	}

	return false;
}
