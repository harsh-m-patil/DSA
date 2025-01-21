package arrays;

// 73. Set Matrix Zeroes
// https://leetcode.com/problems/set-matrix-zeroes/description/
// Given an m x n integer matrix matrix, if an element is 0, set its entire row
// and column to 0's.You must do it in place.

class Solution {
  // Time Complexity O(m*n)
  public void setZeroesOmn(int[][] matrix) {
    // O(m+n) memory to store which rows and cols to set to zero
    int[] rows = new int[matrix[0].length];
    int[] cols = new int[matrix.length];

    // Check which rows and cols need to be set to zero
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rows[j] = 1;
          cols[i] = 1;
        }
      }
    }

    // Set rows with rows[i] = 1 to zero
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (rows[j] == 1) {
          matrix[i][j] = 0;
        }
      }
    }

    // Set cols with cols[i] = 1 to zero
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (cols[i] == 1) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  // Time Complexity: O(m * n), Space Complexity: O(1)
  public void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    // Flag to indicate if the first row needs to be set to zero
    boolean firstRowZero = false;
    // Flag to indicate if the first column needs to be set to zero
    boolean firstColZero = false;

    // Step 1: Check if the first row or column should be zero
    for (int i = 0; i < rows; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }
    for (int j = 0; j < cols; j++) {
      if (matrix[0][j] == 0) {
        firstRowZero = true;
        break;
      }
    }

    // Step 2: Use the first row and column to mark rows and columns that need
    // to be set to zero
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0; // Mark the first cell of the row
          matrix[0][j] = 0; // Mark the first cell of the column
        }
      }
    }

    // Step 3: Set the rows and columns to zero based on the markers
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < cols; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }

    // Step 4: Handle the first row and first column separately
    if (firstColZero) {
      for (int i = 0; i < rows; i++) {
        matrix[i][0] = 0;
      }
    }
    if (firstRowZero) {
      for (int j = 0; j < cols; j++) {
        matrix[0][j] = 0;
      }
    }
  }
}
