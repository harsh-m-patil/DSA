function removeElement(nums: number[], val: number): number {
  let j = 0;

  for (let i = 0; i < nums.length; i++) {
    // only move ahead if the number is not equal to val
    if (nums[i] !== val) {
      nums[j] = nums[i];
      j++;
    }
  }

  return j;
}
