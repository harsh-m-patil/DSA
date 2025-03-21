class Solution {
  public int[] twoSumLinearTime(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;

    while (left < right) {
      int sum = numbers[left] + numbers[right];

      if (sum == target) {
        return new int[] {left + 1, right + 1};
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }

    return new int[] {-1, -1};
  }

  public int[] twoSum(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      // calculate the number we want to find
      int diff = target - numbers[i];
      int idx = search(numbers, i + 1, numbers.length - 1, diff);

      if (idx != -1) {
        return new int[] {i + 1, idx + 1};
      }
    }

    return new int[] {-1, -1};
  }

  /**
   * function to search in a subarray
   */
  public static int search(int[] numbers, int start, int end, int target) {
    int left = start;
    int right = end;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (numbers[mid] == target) {
        return mid;
      } else if (numbers[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }
}
