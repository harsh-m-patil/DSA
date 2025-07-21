class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    int min = Integer.MAX_VALUE;
    int L = 0, sum = 0;

    for (int R = 0; R < nums.length; R++) {
      // add the current number to the sum
      sum += nums[R];
      // slide the window from the left until the sum is less target
      while (sum >= target) {
        // take min of current length and min
        min = Math.min(min, R - L + 1);
        // decrease the sum by removing leftmost value
        sum -= nums[L];
        // reduce the window size
        L++;
      }
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
