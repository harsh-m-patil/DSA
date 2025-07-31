/**
 * @param nums {number[]} - Array of maximum jump lengths
 * @returns {boolean} Can reach the end or not
 *
 * @remarks
 * Time Complexity O(n)
 * Space Complexity O(1)
 */
function canJump(nums: number[]): boolean {
  let maxIdx = 0;

  for (let i = 0; i < nums.length; i++) {
    if (i > maxIdx) return false;
    maxIdx = Math.max(maxIdx, i + nums[i]);
  }

  return true;
}
