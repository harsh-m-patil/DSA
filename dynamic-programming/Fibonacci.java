
/**
 * Fibonacci
 */
public class Fibonacci {
  public static void main(String[] args) {
    int n = 50; // Example value for n
    int result = fibonacciRecursive(n);
    System.out.println("Fibonacci of " + n + " is: " + result);

    int resultBetter = fibonacciMemoized(n);
    System.out.println("Fibonacci of " + n +
                       " using better method is: " + resultBetter);
  }

  // brute force solution O(2^n)
  public static int fibonacciRecursive(int n) {
    if (n <= 1) {
      return n;
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
  }

  public static int fibonacciMemoized(int n) {
    int[] vals = new int[n + 1];
    vals[0] = 0;
    vals[1] = 1;

    for (int i = 2; i <= n; i++) {
      vals[i] = vals[i - 1] + vals[i - 2];
    }
    return vals[n];
  }
}
