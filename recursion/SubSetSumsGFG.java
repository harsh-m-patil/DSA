package recursion;

import java.util.ArrayList;

// Subset Sums
// https://www.geeksforgeeks.org/problems/subset-sums2234/1
// Given a array arr of integers, return the sums of all subsets in the list.
// Return the sums in any order.
// Time Complexity: O(2^n)
// Space Complexity: O(2^n)

class Solution {
  public ArrayList<Integer> subsetSums(int[] arr) {
    ArrayList<Integer> arrayList = new ArrayList<>();

    sum(0, 0, arr, arrayList);

    return arrayList;
  }

  static void sum(int idx, int sum, int[] arr, ArrayList<Integer> arrayList) {
    if (idx == arr.length) {
      arrayList.add(sum);
      return;
    }

    // Take the number in the sum
    sum(idx + 1, sum + arr[idx], arr, arrayList);

    // Do not take the number
    sum(idx + 1, sum, arr, arrayList);
  }
}
