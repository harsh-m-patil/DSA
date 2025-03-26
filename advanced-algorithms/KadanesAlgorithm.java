class KadanesAlogrithm {
  public static int maxSumSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = Integer.MIN_VALUE;

    for (int num : nums) {
      currSum = Math.max(currSum, 0);
      currSum += num;
      maxSum = Math.max(maxSum, currSum);
    }

    return maxSum;
  }

  public static int[] slidingWindow(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    int left = 0, right = 0;
    int maxLeft = 0, maxRight = 0;

    while (right < nums.length) {
      if (currSum < 0) {
        currSum = 0;
        left = right;
      }

      currSum += nums[right];

      if (currSum > maxSum) {
        maxSum = currSum;
        maxLeft = left;
        maxRight = right;
      }
      right++;
    }

    return new int[] {maxLeft, maxRight};
  }

  public static int bruteForce(int[] nums) {
    int maxSum = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int currSum = 0;
      for (int j = i; j < nums.length; j++) {
        currSum += nums[j];
        maxSum = Math.max(maxSum, currSum);
      }
    }

    return maxSum;
  }
}
