package arrays;

// 1672. Richest Customer Wealth You are given an m x n integer grid accounts
// https://leetcode.com/problems/richest-customer-wealth/description/
// where accounts[i][j] is the amount of money the ith customer has in the j th
// bank. Return the wealth that the richest customer has.A customer's wealth is
// the amount of money they have in all their bank accounts. The richest
// customer is the customer that has the maximum wealth.

class Solution {
  public int maximumWealth(int[][] accounts) {
    int ans = Integer.MIN_VALUE;
    for (int person = 0; person < accounts.length; person++) {
      int sum = 0;
      for (int account = 0; account < accounts[person].length; account++) {
        sum += accounts[person][account];
      }

      if (sum > ans) {
        ans = sum;
      }
    }

    return ans;
  }
}
