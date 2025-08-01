/**
 Do not return anything, modify nums in-place instead.
 */
function rotate(nums: number[], k: number): void {
  k %= nums.length;
  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);
}

function reverse(nums: number[], left: number, right: number): void {
  while (left < right) {
    let tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
    left++;
    right--;
  }
}
