// two pointers fast and slow
function removeDuplicates(nums: number[]): number {
  let j = 0;

  for (let i = 1; i < nums.length; i++) {
    if (nums[j] !== nums[i]) {
      j++;
      nums[j] = nums[i];
    }
  }

  return j + 1;
}
