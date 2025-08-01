function twoSum(nums: number[], target: number): number[] {
  const map = new Map<number, number>();

  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    const compliment = target - num;
    if (map.has(compliment)) return [map.get(compliment)!, i];
    map.set(num, i);
  }

  return [];
}
