class Solution {
  public void sortColors(int[] nums) {
    int[] count = new int[3];

    for (int num : nums) {
      count[num]++;
    }

    int i = 0;

    while (count[0]-- > 0)
      nums[i++] = 0;
    while (count[1]-- > 0)
      nums[i++] = 1;
    while (count[2]-- > 0)
      nums[i++] = 2;
  }
}
