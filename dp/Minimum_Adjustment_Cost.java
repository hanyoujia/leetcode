public int MinAdjustmentCost(List<Integer> A, int target) {
        if(A == null || A.size() == 0){
            return 0;
        }
        int n = A.size();
        int[][] dp = new int[2][101];
        int[] f = new int[101];
         Arrays.fill(dp[1],Integer.MAX_VALUE);
        for(int i = 1; i <= n; i++){
            Arrays.fill(dp[i % 2],Integer.MAX_VALUE);
            for(int j = 1; j <= 100; j++){
                for(int k = Math.max(1, j - target); k <= Math.min(100, j + target); k++){
                        dp[i % 2][j] = Math.min(dp[i % 2][j],dp[(i - 1) % 2][k] 
                        + Math.abs(A.get(i - 1) - j));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; i++){
            ans = Math.min(ans,dp[n % 2][i]);
        }
        return ans;
}