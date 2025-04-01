function lastStoneWeight(stones: number[]): number {
	// BUG: if we use stones.sort() it will lexicographically by converting to string
	// stones.sort
	stones.sort((a, b) => a - b);

	while (stones.length > 1) {
		const first = stones[stones.length - 1];
		const second = stones[stones.length - 2];

		if (first === second) {
			stones.pop();
			stones.pop();
		} else {
			stones[stones.length - 2] = Math.abs(first - second);
			stones.pop();
			stones.sort((a, b) => a - b);
		}
	}

	console.log(stones);
	return stones.length === 0 ? 0 : stones[0];
}
