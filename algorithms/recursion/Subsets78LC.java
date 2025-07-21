package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

// 78 SubSets
// https://leetcode.com/problems/subsets/description/
// Given an integer array nums of unique elements, return all possible subsets
// (the power set). The solution set must not contain duplicate subsets. Return
// the solution in any order.
// Time Complexity: O(n*2^n)
// Space Complexity: O(n*2^n)

class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> setOfSubsets = new ArrayList<>();
    List<Integer> subSet = new ArrayList<>();

    createSubset(0, subSet, nums, setOfSubsets);

    return setOfSubsets;
  }

  static void createSubset(int idx, List<Integer> subSet, int[] nums,
                           List<List<Integer>> setOfSubSets) {

    if (idx == nums.length) {
      // create a new arraylist to  avoid unintented mutation
      setOfSubSets.add(new ArrayList<>(subSet));
      return;
    }

    subSet.add(nums[idx]);
    createSubset(idx + 1, subSet, nums, setOfSubSets);

    subSet.remove(subSet.size() - 1);
    createSubset(idx + 1, subSet, nums, setOfSubSets);
  }
}
