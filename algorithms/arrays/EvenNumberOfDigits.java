package algorithms.arrays;

// 1295. Find Numbers with Even Number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
// Given an array nums of integers, return how many of them contain an even
// number of digits.

class Solution {
  public int findNumbers(int[] nums) {
    int res = 0;

    for (int num : nums) {
      if (checkEven(num)) {
        res++;
      }
    }

    return res;
  }

  static boolean checkEven(int num) { return (countDigitsLog(num) % 2) == 0; }

  static int countDigitsLog(int num) { return (int)Math.log10(num) + 1; }

  static int countDigits(int num) {
    int x = Math.abs(num);
    int count = 0;
    while (x > 0) {
      count++;
      x /= 10;
    }
    return count;
  }
}
