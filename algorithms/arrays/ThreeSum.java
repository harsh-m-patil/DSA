import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0)
        break; // no further solutions
      if (i > 0 && nums[i] == nums[i - 1])
        continue; // duplicate number

      int l = i + 1, r = nums.length - 1;

      while (l < r) {
        int sum = nums[l] + nums[r] + nums[i];
        if (sum > 0) {
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));
          l++;
          r--;
          // move until we find a unique number
          while (l < r && nums[l] == nums[l - 1]) {
            l++;
          }
        }
      }
    }

    return result;
  }
}
