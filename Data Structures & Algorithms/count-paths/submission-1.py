class Solution:
    def uniquePaths(self, m: int, n: int, memo = {}) -> int:
        dp = [0] * (n+1)
        dp[1] = 1
        for i in range(1, m+1):
            curr = [0] * (n+1)
            for j in range(1, n+1):
                curr[j] += dp[j]
                if j+1 <= n: 
                    dp[j+1] += dp[j]
        return dp[n]