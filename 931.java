class Solution {
  public int minFallingPathSum(int[][] A) {
    int[][] dp = new int[A.length][A[0].length];
    for (int col = 0; col < A[0].length; col++) {
      dp[0][col] = A[0][col];
    }
    
    for (int row = 1; row < A.length; row++) {
      for (int col = 0; col < A[0].length; col++) {
        dp[row][col] = dp[row-1][col];
        if (col != 0) {
          dp[row][col] = Math.min(dp[row][col], dp[row-1][col-1]);          
        }
        if (col != A[0].length-1) {
          dp[row][col] = Math.min(dp[row][col], dp[row-1][col+1]); 
        }
        dp[row][col] += A[row][col];
      }
    }
    
    int minFall = dp[A.length-1][0];
    for (int col = 1; col < A[0].length; col++) {
      minFall = Math.min(minFall, dp[A.length-1][col]);
    }
    return minFall;
  }
}